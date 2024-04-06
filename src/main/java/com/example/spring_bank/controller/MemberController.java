package com.example.spring_bank.controller;

import com.example.spring_bank.dto.AccountDTO;
import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.AccountEntity;
import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.repository.MemberRepository;
import com.example.spring_bank.service.AccountService;
import com.example.spring_bank.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;

@RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;

    //    회원가입 화면
    @GetMapping("register")
    public String sign(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "register";
    }

    // 회원가입 성공
    @PostMapping("register_form")
    public String registerMember(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberService.MemberCreate(memberDTO, passwordEncoder);
        memberService.saveMember(memberEntity);
        return "redirect:/sign";
    }

    //아이디 중복확인
    @PostMapping("check-memberId")
    @ResponseBody
    public boolean checkMemberIdDuplicate(@RequestParam("memberId") String memberId) {
        return memberService.checkMemberIdDuplicate(memberId);
    }

    //이메일 중복확인
    @PostMapping("check-memberEmail")
    @ResponseBody
    public boolean checkMemberEmailDuplicate(@RequestParam("memberEmail") String memberEmail) {
        return memberService.checkMemberEmailDuplicate(memberEmail);
    }

}
