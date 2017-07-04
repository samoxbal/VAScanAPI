package ru.vascan.api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Document(collection = "scans")
@RequiredArgsConstructor
public class Scan {

    @Id
    @Getter
    private String id;

    @Getter
    @NonNull
    private String voltamogramm;

    @Getter
    private String date;

    @Getter
    @NonNull
    private Float startPotential;

    @Getter
    @NonNull
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
    @NonNull
    private Float temperature;

    @Getter
    @NonNull
    private Float pressure;
}
