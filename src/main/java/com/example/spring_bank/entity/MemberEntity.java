package com.example.spring_bank.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Setter
@Getter
@Entity
@NoArgsConstructor //파라미터가 없는 기본 생성자 생성
@AllArgsConstructor//모든 필드 값을 파라미터로 받는 생성자 생성
@Table(name = "TBL_MEMBER")
public class MemberEntity {

//  회원가입 열
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_num")
    private Long memberNum;

//    아이디
    @Column(name = "member_id",unique = true)
    private String memberId;
//    비밀번호
    @Column(name = "member_pw",nullable = false)
    private String memberPw;
//    이메일
    @Column(name = "member_email",unique = true)
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



}
