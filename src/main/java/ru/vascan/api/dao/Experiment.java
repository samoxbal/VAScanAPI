package ru.vascan.api.dao;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;
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
    @Setter
    @NonNull
    private String name;

    @Getter
    @Setter
    @NonNull
    private String description;

    @Getter
    @Setter
    @NonNull
    private String startDate;

    @Getter
    @Setter
    @NonNull
    private String endDate;
}
