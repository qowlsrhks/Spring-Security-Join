package com.example.spring_bank.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class TransactionDTO {

    private Long transactionId;

    private String fromAccountId;

    private String toAccountId;

    private BigDecimal transactionAmount;

    private Timestamp transactionCreateAt;

    private String transactionStatus;


}
