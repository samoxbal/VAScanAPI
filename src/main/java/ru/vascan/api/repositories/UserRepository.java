package ru.vascan.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.vascan.api.entities.User;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String> {
    public List<User> findByEmail(String email);
}
