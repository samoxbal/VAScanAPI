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

    }
}
