package com.example.spring_bank.service;


import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder encoder;

//    회원가입
    public void registerMember(MemberDTO memberDTO) {
        MemberEntity memberEntity = new MemberEntity();

        memberEntity.setUserName(memberDTO.getUserName());
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setMemberPw(encoder.encode(memberDTO.getMemberPw()));
        memberEntity.setMemberRole("ROLE_USER");
        memberEntity.setCreatedAt(memberDTO.getCreatedAt());
        memberEntity.setUpdatedAt(memberDTO.getUpdateAt());

        memberRepository.save(memberEntity);
    }

    public void loginMember(String memberEmail,String memberPw) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(memberEmail);
        if (userDetails != null  && encoder.matches(memberPw, userDetails.getPassword())) {
            System.out.println("로그인 성공");
            SecurityContextHolder.getContext();
        }else{
            throw new BadCredentialsException("Invalid email or password");
        }
    }


//    이메일 중복 확인
    public boolean checkMemberEmailDuplicate(String memberEmail) {
        return !memberRepository.existsByMemberEmail(memberEmail);
    }

}
