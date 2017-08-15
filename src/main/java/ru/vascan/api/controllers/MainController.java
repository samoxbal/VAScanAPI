package ru.vascan.api.controllers;

import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ru.vascan.api.dao.User;
import ru.vascan.api.entities.ResponseData;
import ru.vascan.api.repositories.UserRepository;
import ru.vascan.api.security.TokenAuthenticationService;

import javax.servlet.ServletException;
import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

@RestController
public class MainController {

    @Autowired
    private UserRepository userService;

    @SneakyThrows
    private String generateHashPwd(String pwd) {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pwd.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter
                .printHexBinary(digest)
                .toLowerCase();
    }

    @SneakyThrows
    @RequestMapping(value = "/token", method = RequestMethod.POST, produces = "application/json")
    public ResponseData generateToken(@RequestBody User login)
    {

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

        if (!pwd.equals(this.generateHashPwd(password))) {
            throw new ServletException("Invalid password");
        }

        return new ResponseData(TokenAuthenticationService.buildToken(user.getId()));
    }
}
