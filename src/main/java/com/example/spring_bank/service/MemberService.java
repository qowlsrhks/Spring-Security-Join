package com.example.spring_bank.service;


import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.AccountEntity;
import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.repository.MemberRepository;
import com.example.spring_bank.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;

//    회원가입
    public MemberEntity saveMember(MemberEntity memberEntity) {
        return memberRepository.save(memberEntity);
    }

//    비밀번호 암호화
    public static MemberEntity MemberCreate(MemberDTO memberDTO, PasswordEncoder passwordEncoder) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberId(memberDTO.getMemberId());
        String password = passwordEncoder.encode(memberDTO.getMemberPw());
        memberEntity.setMemberPw(password);
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setRole(Role.ADMIN);
        return memberEntity;
    }

    

//    아이디 중복확인
    public boolean checkMemberIdDuplicate(String memberId) {
        return !memberRepository.existsByMemberId(memberId);
    }

    
//    이메일 중복 확인s
    public boolean checkMemberEmailDuplicate(String memberEmail) {
        return !memberRepository.existsByMemberEmail(memberEmail);
    }
}
