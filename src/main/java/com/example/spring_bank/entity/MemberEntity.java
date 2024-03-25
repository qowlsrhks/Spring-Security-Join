package com.example.spring_bank.entity;

import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.lang.reflect.Member;

@Setter
@Getter
@Entity
@NoArgsConstructor //파라미터가 없는 기본 생성자 생성
@AllArgsConstructor//모든 필드 값을 파라미터로 받는 생성자 생성
@Table(name = "TBL_MEMBER")
public class MemberEntity {

    @Id
    @Column(name = "member_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNum;

    @Column(name = "member_id", unique = true)
    private String memberId;

    @Column(name = "member_pw")
    private String memberPw;

    @Column(name = "member_email",unique = true)
    private String memberEmail;

    @Enumerated(EnumType.STRING)
    private Role role;

    public static MemberEntity MemberCreate(MemberDTO memberDTO, PasswordEncoder passwordEncoder) {
        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberId(memberDTO.getMemberId());
        String password = passwordEncoder.encode(memberDTO.getMemberPw());
        memberEntity.setMemberPw(password);
        memberEntity.setMemberEmail(memberDTO.getMemberEmail());
        memberEntity.setRole(Role.ADMIN);
        return memberEntity;
    }


}
