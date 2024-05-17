package com.example.spring_bank.controller;

import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.service.MemberService;
import com.example.spring_bank.service.SignService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.naming.AuthenticationException;

@RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class SignController {

    private final MemberService memberService;

    //    로그인 화면
    @GetMapping("sign")
    public String showSignForm(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "/sign";
    }

    //    로그인 검증
    @PostMapping("sign_form")
    @ResponseBody
    public String signMember(@ModelAttribute MemberDTO memberDTO, HttpServletRequest request, HttpServletResponse response,Model model) {
        memberService.loginMember(memberDTO.getMemberEmail(), memberDTO.getMemberPw());
        System.out.println(memberDTO.getMemberEmail());
        return "/home";
    }
}
