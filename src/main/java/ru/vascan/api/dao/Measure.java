package ru.vascan.api.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Document(collection = "measures")
@RequiredArgsConstructor
public class Measure {

    @Id
    @Getter
    private String id;

    @Getter
    @NonNull
    private String scan;

    @Getter
    @NonNull
    private List<List<Float>> points;
}
