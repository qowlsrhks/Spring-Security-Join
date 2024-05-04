package com.example.spring_bank.dto;

import com.example.spring_bank.entity.AccountEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionDTO {

    private Long transactionId;

    private String fromAccountNum;

    private String toAccountNum;

    private BigDecimal transactionAmount;

    private Timestamp transactionCreateAt;

    private String transactionStatus;


}
