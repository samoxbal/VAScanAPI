package ru.vascan.api.dao;

import lombok.Data;
import lombok.experimental.Accessors;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@Document(collection = "scans")
@Data
@Accessors(chain = true)
public class Scan {

    @Id
    private String id;

    @NotBlank
    private String voltamogramm;

    private String date;

    @NotEmpty
    private Double startPotential;

    @NotEmpty
    private Double endPotential;

    private Boolean reverseDirection;
    private Boolean stirring;
    private Boolean rotation;
    private String channelId;
    private String channelLabel;

    @NotEmpty
    private Double temperature;

    @NotEmpty
    private Double pressure;

    @NotBlank
    private String measureMode;

    private List<Measure> measures;
    private MeasureMode regime;
}
