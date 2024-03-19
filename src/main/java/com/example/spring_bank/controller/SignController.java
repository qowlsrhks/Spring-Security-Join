package com.example.spring_bank.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class SignController {


    @GetMapping("/sign")
    public String sign() {
        return "sign";
    }

}
