package com.example.firstbackend.controllers;

import com.example.firstbackend.FirstbackendApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/welcome")
public class WelcomeController {
    public static void main(String[] args) {
        SpringApplication.run(FirstbackendApplication.class, args);
    }
    @GetMapping
    public String welcome(){
        return "Welcome to Spring boot API";
    }

}
