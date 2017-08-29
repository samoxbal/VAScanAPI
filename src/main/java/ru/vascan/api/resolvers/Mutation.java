package ru.vascan.api.resolvers;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vascan.api.dao.Experiment;
import ru.vascan.api.dao.MeasureMode;
import ru.vascan.api.dao.Voltamogramm;
import ru.vascan.api.dao.Scan;
import ru.vascan.api.entities.MeasureModeInput;
import ru.vascan.api.repositories.ExperimentRepository;
import ru.vascan.api.repositories.VoltamogrammRepository;
import ru.vascan.api.repositories.ScanRepository;

@Component
public class Mutation implements GraphQLRootResolver {

    @Autowired
    private ExperimentRepository experimentService;

    @Autowired
    private VoltamogrammRepository voltamogrammService;

    @Autowired
    private ScanRepository scanService;

    public Experiment createExperiment(
        String user,
        String name,
        String description,
        String startDate,
        String endDate
    )
    {
        Experiment experimentObj = new Experiment()
                .setUser(user)
                .setName(name)
                .setDescription(description)
                .setStartDate(startDate)
                .setEndDate(endDate);
        return experimentService.save(experimentObj);
    }

    public Experiment updateExperiment(
        String id, String name, String description, String startDate, String endDate
    )
    {
        Experiment experiment = experimentService
                .findById(id)
                .setName(name)
                .setDescription(description)
                .setStartDate(startDate)
                .setEndDate(endDate);
            experimentService.save(experiment);
        return experimentService.findById(id);
    }

    public Voltamogramm createVoltamogramm(
        String experiment,
        Boolean cyclic,
        String date,
        String description,
        String solution,
        Integer numberOfElectrodes,
        String equipmentId
    )
    {
        Voltamogramm voltamogrammObj = new Voltamogramm()
                .setExperiment(experiment)
                .setCyclic(cyclic)
                .setDate(date)
                .setDescription(description)
                .setSolution(solution)
                .setNumberOfElectrodes(numberOfElectrodes)
                .setEquipmentId(equipmentId);
        return voltamogrammService.save(voltamogrammObj);
    }

    public Scan createScan(
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
        String measureMode,
        MeasureModeInput modeInput
    )
    {
        Scan scanObj = new Scan()
                .setVoltamogramm(voltamogramm)
                .setDate(date)
                .setStartPotential(startPotential)
                .setEndPotential(endPotential)
                .setReverseDirection(reverseDirection)
                .setStirring(stirring)
                .setRotation(rotation)
                .setChannelId(channelId)
                .setChannelLabel(channelLabel)
                .setTemperature(temperature)
                .setPressure(pressure)
                .setMeasureMode(measureMode)
                .setRegime(new MeasureMode()
                        .setScan(modeInput.getScan())
                        .setNormalPulseLife(modeInput.getNormalPulseLife())
                        .setNormalPulsePeriod(modeInput.getNormalPulsePeriod())
                        .setDifferentialPulseAmplitude(modeInput.getDifferentialPulseAmplitude())
                        .setDifferentialPulsePeriod(modeInput.getDifferentialPulsePeriod())
                        .setDifferentialPulseWidth(modeInput.getDifferentialPulseWidth())
                        .setSquareWaveAmplitude(modeInput.getSquareWaveAmplitude())
                        .setSquareWaveTimePeriod(modeInput.getSquareWaveTimePeriod()));
        return scanService.save(scanObj);
    }
}
