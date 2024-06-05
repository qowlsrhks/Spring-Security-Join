package com.example.spring_bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO{

    private Long memberId;

    private String userName;

    private String memberEmail;

    private String memberPhone;

    private String memberPw;

    private String memberPwCheck;

    private String memberAddress;

    private String memberRole;

    private Timestamp createdAt;

    private Timestamp updateAt;


}

