package com.example.spring_bank.entity;

import com.example.spring_bank.dto.AccountDTO;
import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@Entity
@NoArgsConstructor //파라미터가 없는 기본 생성자 생성
@AllArgsConstructor//모든 필드 값을 파라미터로 받는 생성자 생성
@Table(name = "TBL_MEMBER")
public class MemberEntity {

//  회원가입 열
    @Id
    @Column(name = "member_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberNum;

    @Column(name = "member_id")
    private String memberId;


    @Column(name = "member_pw")
    private String memberPw;

    @Column(name = "member_email",unique = true)
    private String memberEmail;

    @Enumerated(EnumType.STRING)
    private Role role;



}
