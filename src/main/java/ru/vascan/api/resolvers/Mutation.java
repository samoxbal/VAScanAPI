package ru.vascan.api.resolvers;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vascan.api.dao.Experiment;
import ru.vascan.api.dao.Voltamogramm;
import ru.vascan.api.dao.Scan;
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
        Experiment experimentObj = new Experiment(
            user,
            name,
            description,
            startDate,
            endDate
        );
        return experimentService.save(experimentObj);
    }

    public Experiment updateExperiment(
        String id, String name, String description, String startDate, String endDate
    )
    {
        Experiment experiment = experimentService.findById(id);
        experiment.setName(name);
        experiment.setDescription(description);
        experiment.setStartDate(startDate);
        experiment.setEndDate(endDate);
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
        Voltamogramm voltamogrammObj = new Voltamogramm(
            experiment, cyclic, date, description, solution, numberOfElectrodes, equipmentId
        );
        return voltamogrammService.save(voltamogrammObj);
    }

    public Scan createScan(
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
        Scan scanObj = new Scan(
            voltamogramm,
            date,
            startPotential,
            endPotential,
            reverseDirection,
            stirring,
            rotation,
            channelId,
            channelLabel,
            temperature,
            pressure,
            measureMode
        );
        return scanService.save(scanObj);
    }
}
