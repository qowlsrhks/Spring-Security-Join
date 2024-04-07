package com.example.spring_bank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class MemberDTO {

    private Long Id;

    private String memberId;

    private String memberPw;

    private String memberEmail;

    private String userName;

    private Timestamp createdAt;

    private Timestamp updateAt;

}

