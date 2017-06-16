package ru.vascan.api.entities;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    public String id;
    public String email;
    public String password;
}
