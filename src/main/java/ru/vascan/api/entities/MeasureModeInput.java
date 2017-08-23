package ru.vascan.api.entities;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MeasureModeInput {
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
