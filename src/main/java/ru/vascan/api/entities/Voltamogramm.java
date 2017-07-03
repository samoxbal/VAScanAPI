package ru.vascan.api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(collection = "voltamogramms")
@RequiredArgsConstructor
public class Voltamogramm {

    @Id
    @Getter
    private String id;

    @Getter
    @NonNull
    private String experiment;

    @Getter
    @NonNull
    private Boolean cyclic;

    @Getter
    private String date;

    @Getter
    @NonNull
    private String description;

    @Getter
    @NonNull
    private String solution;

    @Getter
    @NonNull
    private Integer numberOfElectrodes;

    @Getter
    private String equipmentId;
}
