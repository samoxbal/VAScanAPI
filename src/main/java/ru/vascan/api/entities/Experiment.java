package ru.vascan.api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;

@Document(collection = "experiments")
public class Experiment {

    @Id
    @Getter
    private String id;

    @Getter
    private String user;

    @Getter
    private String name;

    @Getter
    private String description;

    @Getter
    private String startDate;

    @Getter
    private String endDate;
}
