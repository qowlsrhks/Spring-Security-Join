package com.example.spring_bank.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountDTO {

    private Long fromMemberId;

    private Long toMemberId;

    private BigDecimal amount;
}
