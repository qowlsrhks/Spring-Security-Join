package com.example.spring_bank.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MemberDTO {

    private Long memberNum;

    private String memberId;

    private String memberPw;

    private String memberEmail;


}

