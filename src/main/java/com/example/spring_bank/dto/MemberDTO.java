package com.example.spring_bank.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class MemberDTO {

    private Long memberNum;
    private String memberEmail;
    private String memberId;
    private String memberPw;


}

