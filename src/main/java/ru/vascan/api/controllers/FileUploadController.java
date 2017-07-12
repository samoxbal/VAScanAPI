package ru.vascan.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import ru.vascan.api.entities.Measure;
import ru.vascan.api.repositories.MeasureRepository;

import javax.servlet.ServletException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;
import java.util.ArrayList;

@RestController
public class FileUploadController {

    @Autowired
    private MeasureRepository measureService;

    @PostMapping("/upload")
    public String uploadScanData(
        @RequestParam("scan") String scan,
        @RequestParam("file") MultipartFile file
    ) throws ServletException, IOException
    {
        if (file.isEmpty()) {
            throw new ServletException("Please upload the file");
        }

        InputStream fileInput = file.getInputStream();
        InputStreamReader fileStreamReader = new InputStreamReader(fileInput);
        BufferedReader buffer = new BufferedReader(fileStreamReader);
        Stream<String> lines = buffer.lines();

        List<List<Float>> pointsData = lines
                .map(line -> {
                    String[] parts = line.split("\\s+");
                    List<Float> points = new ArrayList<>();
                    points.add(Float.valueOf(parts[0]));
                    points.add(Float.valueOf(parts[1]));
                    return points;
                })
                .collect(Collectors.toList());

        Measure measureObj = new Measure(scan, pointsData);
        Measure measureSaved = measureService.save(measureObj);

        return measureSaved.getId();
    }
}
