package ru.vascan.api.dao;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@Document(collection = "voltamogramms")
@Data
@Accessors(chain = true)
public class Voltamogramm {

    @Id
    private String id;

    @NotBlank
    private String experiment;

    @NotEmpty
    private Boolean cyclic;

    @NotBlank
    private String date;

    @NotBlank
    private String description;

    @NotBlank
    private String solution;

    private Integer numberOfElectrodes;
    private String equipmentId;
    private List<Scan> scans;
}
