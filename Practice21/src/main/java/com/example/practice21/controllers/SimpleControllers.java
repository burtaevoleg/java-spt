package com.example.practice21.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/home")
public class SimpleControllers {

    @GetMapping
    public String getHomePage(){
        return "home.html";
    }
}
