package ru.vascan.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ru.vascan.api.entities.User;
import ru.vascan.api.repositories.UserRepository;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    UserRepository user;

    @RequestMapping(value = "/**", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(
        value = "/users",
        method = RequestMethod.GET,
        produces = "application/json"
    )
    public List<User> getUsers(@RequestParam String email) {
        return user.findByEmail(email);
    }
}
