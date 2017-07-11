package ru.vascan.api.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Stream;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String uploadScanData(
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

        lines.forEach(line -> {
            String[] parts = line.split("\\s+");

        });

        return file.getContentType();
    }
}
