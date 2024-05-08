package com.example.spring_bank.service;


import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.util.Optional;


@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder encoder;

    @Autowired
    public MemberService(MemberRepository memberRepository, PasswordEncoder encoder) {
        this.memberRepository = memberRepository;
        this.encoder = encoder;
    }

//    회원가입
    @Transactional
    public void register(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();

        if (memberRepository.existsByMemberEmail(memberDTO.getMemberEmail())) {
            throw new IllegalArgumentException("중복된 이메일입니다");
        }

        memberEntity.setUserName(memberDTO.getUsername());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPw(encoder.encode(memberDTO.getMemberPw()));
        memberEntity.setMemberRole(memberDTO.getMemberRole());
        memberEntity.setCreatedAt(memberDTO.getCreatedAt());
        memberEntity.setUpdatedAt(memberDTO.getUpdateAt());

        memberRepository.save(memberEntity);
    }

//    이메일 중복 확인
    public boolean checkMemberEmailDuplicate(String memberEmail) {
        return !memberRepository.existsByMemberEmail(memberEmail);
    }

}
