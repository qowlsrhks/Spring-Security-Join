package com.example.spring_bank.service;

import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.repository.MemberRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SignService{

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    public SignService(MemberRepository memberRepository, PasswordEncoder passwordEncoder) {
        this.memberRepository = memberRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public MemberDTO login(String memberEmail, String memberPw) {
        MemberEntity memberEntity = memberRepository.findByMemberEmail(memberEmail);
        if (memberEntity != null && passwordEncoder.matches(memberPw, memberEntity.getMemberPw())) {
            return convertToDTO(memberEntity);
        }
        return null;
    }

    private MemberDTO convertToDTO(MemberEntity memberEntity) {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberEmail(memberEntity.getMemberEmail());
        memberDTO.setUserName(memberEntity.getUserName());
        memberDTO.setMemberRole(memberEntity.getMemberRole());
        return memberDTO;
    }
}
