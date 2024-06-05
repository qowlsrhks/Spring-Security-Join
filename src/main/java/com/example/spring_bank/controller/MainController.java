package com.example.spring_bank.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String home() {
        return "/index";
    }

    @GetMapping("/home")
    public String mainPage(){
        return "/home";
    }
}
