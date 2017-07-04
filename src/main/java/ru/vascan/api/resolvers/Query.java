package ru.vascan.api.resolvers;

import com.coxautodev.graphql.tools.GraphQLRootResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.vascan.api.entities.Experiment;
import ru.vascan.api.repositories.ExperimentRepository;
import ru.vascan.api.repositories.VoltamogrammRepository;

import java.util.List;

@Component
public class Query implements GraphQLRootResolver {

    @Autowired
    private ExperimentRepository experimentService;

    @Autowired
    private VoltamogrammRepository voltamogrammService;

    public List<Experiment> experiments(String user) {
        return experimentService.findByUser(user);
    }
}
