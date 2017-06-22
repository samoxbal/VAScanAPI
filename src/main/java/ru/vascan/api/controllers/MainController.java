package ru.vascan.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import ru.vascan.api.entities.User;
import ru.vascan.api.repositories.UserRepository;

import javax.servlet.ServletException;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    UserRepository userService;

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
        return userService.findAllByEmail(email);
    }

    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public String generateToken(@RequestBody User login) throws ServletException {

        if (login.getEmail() == null || login.getPassword() == null) {
            throw new ServletException("Please fill in username and password");
        }

        String email = login.getEmail();
        String password = login.getPassword();

        User user = userService.findByEmail(email);

        if (user == null) {
            throw new ServletException("User is not exist");
        }

        String pwd = user.getPassword();

        if (!password.equals(pwd)) {
            throw new ServletException("Invalid password");
        }

        return Jwts
                .builder()
                .setSubject(email)
                .claim("roles", "user")
                .signWith(SignatureAlgorithm.HS256, "secretKey")
                .compact();
    }
}
