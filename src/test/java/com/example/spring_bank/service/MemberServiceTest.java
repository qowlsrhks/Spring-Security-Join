package com.example.spring_bank.service;

import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.MemberEntity;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations="classpath:application-test.properties")
public class MemberServiceTest {

    @Autowired
    MemberService memberService;
    @Autowired
    PasswordEncoder passwordEncoder;

    public MemberEntity createMember() {
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMemberEmail("skswlsrhks@nate.com");
        memberDTO.setMemberId("ohigogo2");
        memberDTO.setMemberPw("1234");
        return MemberService.MemberCreate(memberDTO, passwordEncoder);
    }

    @Test
    @DisplayName("회원가입 테스트")
    public void saveMemberTest() {
        MemberEntity memberEntity = createMember();
        MemberEntity saveMember = memberService.saveMember(memberEntity);
        assertEquals(memberEntity.getMemberEmail(), saveMember.getMemberEmail());
        assertEquals(memberEntity.getMemberId(), saveMember.getMemberId());
        assertEquals(memberEntity.getMemberPw(), saveMember.getMemberPw());
        assertEquals(memberEntity.getRole(),saveMember.getRole());
        System.out.println("아이디"+saveMember.getMemberId());
    }

    @Test
    public void saveDuplicateMemberTest() {
        MemberEntity memberEntity1 = createMember();
        MemberEntity memberEntity2 = createMember();
        memberService.saveMember(memberEntity1);
        Throwable e = assertThrows(IllegalStateException.class,() ->{
           memberService.saveMember(memberEntity2);
        });
        assertEquals("이미 가입된 회원입니다",e.getMessage());
    }
}
