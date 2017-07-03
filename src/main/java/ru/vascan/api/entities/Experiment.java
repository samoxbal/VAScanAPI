package ru.vascan.api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(collection = "experiments")
@RequiredArgsConstructor
public class Experiment {

    @Id
    @Getter
    private String id;

    @Getter
    @NonNull
    private String user;

    @Getter
    @NonNull
    private String name;

    @Getter
    @NonNull
    private String description;

    @Getter
    @NonNull
    private String startDate;

    @Getter
    @NonNull
    private String endDate;
}
