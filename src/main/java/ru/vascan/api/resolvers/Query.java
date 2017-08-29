package ru.vascan.api.resolvers;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import io.reactivex.Observable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vascan.api.dao.*;
import ru.vascan.api.repositories.ExperimentRepository;
import ru.vascan.api.repositories.VoltamogrammRepository;
import ru.vascan.api.repositories.ScanRepository;
import ru.vascan.api.repositories.MeasureRepository;
import ru.vascan.api.repositories.MeasureModeRepository;

import java.util.List;

@Component
public class Query implements GraphQLRootResolver {

    @Autowired
    private ExperimentRepository experimentService;

    @Autowired
    private VoltamogrammRepository voltamogrammService;

    @Autowired
    private ScanRepository scanService;

    @Autowired
    private MeasureRepository measureService;

    @Autowired
    private MeasureModeRepository measureModeService;

    public List<Experiment> experiments(String user) {
        return experimentService.findByUser(user);
    }

    public List<Voltamogramm> voltamogramms(String experiment) {
        return voltamogrammService.findByExperiment(experiment);
    }

    public Voltamogramm voltamogramm(String voltamogrammId) {
        return Observable.zip(
            Observable.just(scanService.findByVoltamogramm(voltamogrammId)),
            Observable.just(voltamogrammService.findById(voltamogrammId)),
                (scans, voltamogramm) -> {
                    voltamogramm.setScans(scans);
                    return voltamogramm;
                }
        ).blockingSingle();
    }

    public List<Measure> measures(String scan) {
        return measureService.findByScan(scan);
    }

    public Measure measure(String id) {
        return measureService.findById(id);
    }

    public Scan scan(String scanId) {
        List<Measure> measures = this.measures(scanId);
        Scan scan = scanService.findById(scanId);
        scan.setMeasures(measures);
        MeasureMode regime = measureModeService.findByScan(scanId);
        scan.setRegime(regime);
        return scan;
    }
}
