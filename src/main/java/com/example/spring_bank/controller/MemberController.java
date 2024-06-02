package com.example.spring_bank.controller;

import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    //    회원가입 화면
    @GetMapping("register")
    public String register(Model model) {
        model.addAttribute("member", new MemberDTO());
        return "/register";
    }

    @PostMapping("register_form")
    public String registerForm(@ModelAttribute("member") MemberDTO memberDTO) {
        memberService.registerMember(memberDTO);
        return "/home";
    }


    @PostMapping("check_member_email")
    @ResponseBody
    public boolean checkMemberEmail(@RequestParam String memberEmail) {
         return memberService.checkMemberEmailDuplicate(memberEmail);
    }
}
