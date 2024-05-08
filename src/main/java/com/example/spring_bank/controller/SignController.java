package com.example.spring_bank.controller;

import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.service.SignService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@Controller
public class SignController {

    private final SignService signService;

    public SignController(SignService signService) {
        this.signService = signService;
    }


    //    로그인 화면
    @GetMapping("sign")
    public String showSignForm() {
        return "/sign";
    }

    //    로그인 검증

    @PostMapping("sign_form")
    public String login(MemberDTO memberDTO) {
        signService.login(memberDTO.getMemberEmail(), memberDTO.getMemberPw());
        return "/home";
    }

}
