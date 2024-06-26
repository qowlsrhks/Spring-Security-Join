package com.example.spring_bank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.Collection;

@Setter
@Getter
@Entity
@NoArgsConstructor //파라미터가 없는 기본 생성자 생성
@AllArgsConstructor//모든 필드 값을 파라미터로 받는 생성자 생성
@Table(name = "TBL_MEMBER")
public class MemberEntity{

//  회원가입 열
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long memberId;
    
//    비밀번호
    @Column(name = "member_pw",nullable = false)
    private String memberPw;
//    이메일&아이디
    @Column(name = "member_email",unique = true,nullable = false
    )
    private String memberEmail;
//    가입자 실명
    @Column(name = "user_name",nullable = false)
    private String userName;
//    생성날짜
    @CreationTimestamp
    @Column(name="created_at")
    private Timestamp createdAt;
//   개인정보 변경 날짜
    @UpdateTimestamp
    @Column(name = "updated_at")
    private  Timestamp updatedAt;

    //    필수 요소 로그인 진행한 사용자가 USER인지 ADMIN인지 설정
    @Column(name = "member_role")
    @ElementCollection
    private Collection<String> memberRole;



}
