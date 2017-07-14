package ru.vascan.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.vascan.api.dao.Voltamogramm;
import java.util.List;

public interface VoltamogrammRepository extends MongoRepository<Voltamogramm, String> {
    List<Voltamogramm> findByExperiment(String experiment);
    Voltamogramm findById(String id);
}
