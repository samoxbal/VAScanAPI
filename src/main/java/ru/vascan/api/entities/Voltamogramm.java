package ru.vascan.api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Document(collection = "voltamogramms")
@RequiredArgsConstructor
public class Voltamogramm {

    public Voltamogramm(String experiment,
                        Boolean cyclic,
                        String date,
                        String description,
                        String solution,
                        Integer numberOfElectrodes,
                        String equipmentId)
    {
        this.experiment = experiment;
        this.cyclic = cyclic;
        this.date = date;
        this.description = description;
        this.solution = solution;
        this.numberOfElectrodes = numberOfElectrodes;
        this.equipmentId = equipmentId;
    }

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

    @Getter
    @Setter
    private List<Scan> scans;
}
