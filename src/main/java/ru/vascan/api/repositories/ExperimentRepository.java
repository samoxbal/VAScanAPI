package ru.vascan.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.vascan.api.entities.Experiment;
import java.util.List;

public interface ExperimentRepository extends MongoRepository<Experiment, String> {
    List<Experiment> findByUser(String user);
    Experiment findById(String id);
}
