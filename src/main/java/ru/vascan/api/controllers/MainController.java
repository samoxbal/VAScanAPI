package ru.vascan.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ru.vascan.api.entities.User;
import ru.vascan.api.repositories.UserRepository;
import ru.vascan.api.security.TokenAuthenticationService;

import javax.servlet.ServletException;
import javax.xml.bind.DatatypeConverter;
import java.util.List;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@RestController
public class MainController {

    @Autowired
    UserRepository userService;

    private String generateHashPwd(String pwd) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(pwd.getBytes());
        byte[] digest = md.digest();
        return DatatypeConverter
                .printHexBinary(digest)
                .toLowerCase();
    }

    @RequestMapping(value = "/**", method = RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(
        value = "/token",
        method = RequestMethod.POST,
        produces = "application/json"
    )
    public String generateToken(@RequestBody User login)
            throws ServletException, NoSuchAlgorithmException {

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

        return TokenAuthenticationService.buildToken(email);
    }
}
