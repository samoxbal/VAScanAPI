package ru.vascan.api.resolvers;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vascan.api.entities.Experiment;
import ru.vascan.api.entities.Voltamogramm;
import ru.vascan.api.entities.Scan;
import ru.vascan.api.repositories.ExperimentRepository;
import ru.vascan.api.repositories.VoltamogrammRepository;
import ru.vascan.api.repositories.ScanRepository;

import java.util.List;

@Component
public class Query implements GraphQLRootResolver {

    @Autowired
    private ExperimentRepository experimentService;

    @Autowired
    private VoltamogrammRepository voltamogrammService;

    @Autowired
    private ScanRepository scanService;

    public List<Experiment> experiments(String user) {
        return experimentService.findByUser(user);
    }

    public List<Voltamogramm> voltamogramms(String experiment) {
        return voltamogrammService.findByExperiment(experiment);
    }

    public Voltamogramm voltamogramm(String voltamogrammId) {
        List<Scan> scans = scanService.findByVoltamogramm(voltamogrammId);
        Voltamogramm voltamogramm = voltamogrammService.findById(voltamogrammId);
        voltamogramm.setScans(scans);
        return voltamogramm;
    }
}
