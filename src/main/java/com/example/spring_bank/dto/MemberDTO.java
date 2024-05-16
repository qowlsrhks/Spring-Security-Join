package com.example.spring_bank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberDTO{

    private Long memberId;

    private String memberEmail;

    private String memberPw;

    private String memberPwCheck;

    private String userName;

    private String role;

    private Timestamp createdAt;

    private Timestamp updateAt;

}

