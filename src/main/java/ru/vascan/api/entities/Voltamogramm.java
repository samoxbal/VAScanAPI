package ru.vascan.api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@Document(collection = "voltamogramms")
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
    @NotBlank
    private String experiment;

    @Getter
    @NotNull
    private Boolean cyclic;

    @Getter
    private String date;

    @Getter
    @NotBlank
    private String description;

    @Getter
    @NotBlank
    private String solution;

    @Getter
    @NotNull
    private Integer numberOfElectrodes;

    @Getter
    private String equipmentId;

    @Getter
    @Setter
    private List<Scan> scans;
}
