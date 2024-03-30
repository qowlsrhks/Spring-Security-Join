package com.example.spring_bank.controller;

import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.repository.MemberRepository;
import com.example.spring_bank.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("register")
    public String sign(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "register";
    }
    @PostMapping("check-memberId")
    @ResponseBody
    public boolean checkMemberIdDuplicate(@RequestParam("memberId") String memberId) {
        return memberService.checkMemberIdDuplicate(memberId);
    }
    @PostMapping("check-memberEmail")
    public boolean checkMemberEmailDuplicate(@RequestParam("memberEmail") String memberEmail) {
        return memberService.checkMemberEmailDuplicate(memberEmail);
    }

    @PostMapping("register-form")
    public String registerMember(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.MemberCreate(memberDTO, passwordEncoder);
        memberService.saveMember(memberEntity);
        return "redirect:/";
    }

}
