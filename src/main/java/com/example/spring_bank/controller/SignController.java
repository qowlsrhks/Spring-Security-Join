package com.example.spring_bank.controller;

import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.service.MemberService;
import com.example.spring_bank.service.SignService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class SignController {

    private final MemberService memberService;

//    로그인 화면
    @GetMapping("sign")
    public String showSignForm() {
        return "/sign";
    }

    //    로그인 검증
    @PostMapping("sign_form")
    @ResponseBody
    public String signMember(@RequestParam("member_email") String memberEmail, Model model) {
        String result = memberService.loginMember(memberEmail);
        if(result.equals("login_fail")){
            model.addAttribute("errorMessage", "Invalid email or password");
            return "/sign";
        }else{
            return "redirect:/home";
        }
    }
}
