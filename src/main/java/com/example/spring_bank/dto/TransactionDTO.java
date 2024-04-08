package com.example.spring_bank.dto;

import com.example.spring_bank.entity.AccountEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class TransactionDTO {

    private Long transactionId;

    private AccountEntity fromAccountNum; //AccountEntity참조

    private AccountEntity toAccountNum; //AccountEntity참조

    private BigDecimal transactionAmount;

    private Timestamp transactionCreateAt;

    private String transactionStatus;


}
