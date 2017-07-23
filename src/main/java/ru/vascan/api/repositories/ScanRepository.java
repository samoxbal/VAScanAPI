package ru.vascan.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.vascan.api.dao.Scan;
import java.util.List;

public interface ScanRepository extends MongoRepository<Scan, String> {
    List<Scan> findByVoltamogramm(String voltamogrammId);
    Scan findById(String scanId);
}
