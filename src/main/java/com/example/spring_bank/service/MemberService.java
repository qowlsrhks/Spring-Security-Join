package com.example.spring_bank.service;


import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
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

    public String loginMember(String memberEmail,String memberPw) {
        MemberEntity memberEntity = memberRepository.findByMemberEmail(memberEmail);
        if (memberEntity == null) {
            return "login_fail";
        }
        return "login_success";

        encoder.matches(memberEntity.getMemberPw(),memberPw);
    }


//    이메일 중복 확인
    public boolean checkMemberEmailDuplicate(String memberEmail) {
        return !memberRepository.existsByMemberEmail(memberEmail);
    }

}
