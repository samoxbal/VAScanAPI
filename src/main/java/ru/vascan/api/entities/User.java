package ru.vascan.api.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Getter;
import lombok.AllArgsConstructor;

@Document(collection = "users")
@AllArgsConstructor
public class User {

    @Id
    @Getter
    public String id;

    @Getter
    private String email;

    @Getter
    private String password;
}
