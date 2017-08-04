package ru.vascan.api.dao;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
@Data
@Accessors(chain = true)
public class User {

    @Id
    public String id;
    private String email;
    private String password;
}
