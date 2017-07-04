package ru.vascan.api.resolvers;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vascan.api.entities.Experiment;
import ru.vascan.api.repositories.ExperimentRepository;

@Component
public class Mutation implements GraphQLRootResolver {

    @Autowired
    private ExperimentRepository experimentService;

    public Experiment createExperiment(
        String user, String name, String description, String startDate, String endDate
    )
    {
        Experiment experimentObj = new Experiment(user, name, description, startDate, endDate);
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
}
