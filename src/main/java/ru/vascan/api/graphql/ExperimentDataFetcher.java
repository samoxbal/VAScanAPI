package ru.vascan.api.graphql;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationContext;

import ru.vascan.api.entities.Experiment;
import ru.vascan.api.repositories.ExperimentRepository;
import java.util.List;

public class ExperimentDataFetcher implements DataFetcher, ApplicationContextAware {

    private static ApplicationContext context;
    private static ExperimentRepository experimentService;

    @Override
    public List<Experiment> get(DataFetchingEnvironment env) {
        return experimentService.findByUser("58de45169eeb372fe303e2b3");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        context = applicationContext;
        experimentService = context.getBean(ExperimentRepository.class);
    }
}
