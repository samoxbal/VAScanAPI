package ru.vascan.api.dao;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "regimes")
@Data
@Accessors(chain = true)
public class MeasureMode {
    private String scan;
    private String normalPulseLife;
    private String normalPulsePeriod;
    private String differentialPulseAmplitude;
    private String differentialPulseWidth;
    private String differentialPulsePeriod;
    private String squareWaveAmplitude;
    private String staircaseWaveEstep;
    private String squareWaveTimePeriod;
    private String staircaseTimeStep;
    private String staircaseEstep;
    private String acAmplitude;
    private String acFrequency;
}
