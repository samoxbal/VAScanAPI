package ru.vascan.api.dao;

import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

import java.util.List;

@Document(collection = "scans")
public class Scan {

    public Scan(
        String voltamogramm,
        String date,
        Double startPotential,
        Double endPotential,
        Boolean reverseDirection,
        Boolean stirring,
        Boolean rotation,
        String channelId,
        String channelLabel,
        Double temperature,
        Double pressure,
        String measureMode
    )
    {
        this.voltamogramm = voltamogramm;
        this.date = date;
        this.startPotential = startPotential;
        this.endPotential = endPotential;
        this.reverseDirection = reverseDirection;
        this.stirring = stirring;
        this.rotation = rotation;
        this.channelId = channelId;
        this.channelLabel = channelLabel;
        this.temperature = temperature;
        this.pressure = pressure;
        this.measureMode = measureMode;
    }

    @Id
    @Getter
    private String id;

    @Getter
    @NotBlank
    private String voltamogramm;

    @Getter
    private String date;

    @Getter
    @NotNull
    private Double startPotential;

    @Getter
    @NotNull
    private Double endPotential;

    @Getter
    private Boolean reverseDirection;

    @Getter
    private Boolean stirring;

    @Getter
    private Boolean rotation;

    @Getter
    private String channelId;

    @Getter
    private String channelLabel;

    @Getter
    @NotNull
    private Double temperature;

    @Getter
    @NotNull
    private Double pressure;

    @Getter
    @NotNull
    private String measureMode;

    @Getter
    @Setter
    private List<Measure> measures;
}
