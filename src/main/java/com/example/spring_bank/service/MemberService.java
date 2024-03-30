package com.example.spring_bank.service;


import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
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
        validateDuplicateMember(memberEntity);
        return memberRepository.save(memberEntity);
    }

    
//    중복 회원 검증
    private void validateDuplicateMember(MemberEntity memberEntity) {
        MemberEntity findMember = memberRepository.findByMemberId(memberEntity.getMemberId());
        if (findMember != null) {
            throw new IllegalStateException("이미 가입된 회원입니다");
        }
    }
    

//    아이디 중복확인
    public boolean checkMemberIdDuplicate(String memberId) {
        return !memberRepository.existsByMemberId(memberId);
    }

    
//    이메일 중복 확인s
    public boolean checkMemberEmailDuplicate(String memberEmail) {
        return (!memberRepository.existsByMemberEmail(memberEmail));
    }
}
