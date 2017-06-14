package ru.vascan.api.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class MainController {

    @RequestMapping("/")
    public @ResponseBody String index() {
        return "okay";
    }
}
