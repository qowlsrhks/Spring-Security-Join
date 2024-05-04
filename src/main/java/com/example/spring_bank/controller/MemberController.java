package com.example.spring_bank.controller;

import com.example.spring_bank.dto.AccountDTO;
import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.AccountEntity;
import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.repository.MemberRepository;
import com.example.spring_bank.service.AccountService;
import com.example.spring_bank.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.thymeleaf.model.IModel;

import java.sql.SQLException;
import java.util.HashMap;

@RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    //    회원가입 화면
    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("member", new MemberDTO());
        return "/register";
    }

    @PostMapping("register_form")
    public String registerForm(@ModelAttribute("member") MemberDTO memberDTO) {
        memberService.register(memberDTO);
        return "/sign";
    }


    @PostMapping("check_member_email")
    @ResponseBody
    public boolean checkMemberEmail(@RequestParam String memberEmail) {
         return memberService.checkMemberEmailDuplicate(memberEmail);
    }
}
