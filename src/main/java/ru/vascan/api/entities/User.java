package ru.vascan.api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;

@Document(collection = "users")
public class User {

    @Id
    public String id;

    @Getter
    private String email;

    @Getter
    private String password;
}
