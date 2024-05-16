package com.example.spring_bank.service;

import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SignService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;


    @Override
    public UserDetails loadUserByUsername(String memberEmail) throws UsernameNotFoundException {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberEmail(memberEmail);
        memberRepository.findByMemberEmail(memberEmail);
        List<GrantedAuthority> authorityList = new ArrayList<>();
        return new User(memberDTO.getMemberEmail(), memberDTO.getMemberPw(), authorityList);
    }

}
