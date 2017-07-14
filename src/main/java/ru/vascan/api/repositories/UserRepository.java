package ru.vascan.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.vascan.api.dao.User;

public interface UserRepository extends MongoRepository<User, String> {
    User findByEmail(String email);
}
