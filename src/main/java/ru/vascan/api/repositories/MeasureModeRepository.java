package ru.vascan.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.vascan.api.dao.MeasureMode;

public interface MeasureModeRepository extends MongoRepository<MeasureMode, String> {
    MeasureMode findByScan(String scan);
}
