package com.example.spring_bank.service;

import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.repository.MemberRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final MemberRepository memberRepository;

    public CustomUserDetailsService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String memberEmail) throws UsernameNotFoundException {
        MemberEntity memberEntity = memberRepository.findByMemberEmail(memberEmail).orElseThrow(()
                -> new UsernameNotFoundException("User not found with memberEmail"));
        return new org.springframework.security.core.userdetails.User(memberEntity.getMemberEmail(),memberEntity.getMemberPw(), Collections.emptyList());
    }
}
