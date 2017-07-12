package ru.vascan.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.vascan.api.entities.Measure;
import java.util.List;

public interface MeasureRepository extends MongoRepository<Measure, String> {
    List<Measure> findByScan(String scan);
    Measure findById(String id);
}
