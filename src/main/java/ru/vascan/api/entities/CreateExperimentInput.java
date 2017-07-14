package ru.vascan.api.entities;

import lombok.Getter;

public class CreateExperimentInput {

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
