package com.example.spring_bank.controller;

import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.repository.MemberRepository;
import com.example.spring_bank.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final PasswordEncoder passwordEncoder;
    private final MemberRepository memberRepository;

    @GetMapping("register")
    public String sign(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "join";
    }

    @PostMapping("register")
    public String registerMember(MemberDTO memberDTO) {
        MemberEntity memberEntity = MemberEntity.MemberCreate(memberDTO, passwordEncoder);
        memberService.saveMember(memberEntity);
        return "redirect:/";
    }

    @GetMapping("check-memberId/{memberId}/exists")
    public ResponseEntity<Boolean> checkMemberIdDuplicate(@PathVariable("memberId") String memberId) {
        return ResponseEntity.ok(memberService.checkMemberIdDuplicate(memberId));


    }

    @GetMapping("check-memberEmail/{memberEmail}/exists")
    public ResponseEntity<Boolean> checkMemberEmailDuplicate(@PathVariable("memberEmail") String memberEmail) {
        return ResponseEntity.ok(memberService.checkMemberEmailDuplicate(memberEmail));
    }
}
