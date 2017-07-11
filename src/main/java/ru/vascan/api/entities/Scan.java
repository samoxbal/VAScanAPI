package ru.vascan.api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

@Document(collection = "scans")
public class Scan {

    public Scan(
        String voltamogramm,
        String date,
        Float startPotential,
        Float endPotential,
        Boolean reverseDirection,
        Boolean stirring,
        Boolean rotation,
        String channelId,
        String channelLabel,
        Float temperature,
        Float pressure,
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
    private Float startPotential;

    @Getter
    @NotNull
    private Float endPotential;

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
    private Float temperature;

    @Getter
    @NotNull
    private Float pressure;

    @Getter
    @NotNull
    private String measureMode;
}
