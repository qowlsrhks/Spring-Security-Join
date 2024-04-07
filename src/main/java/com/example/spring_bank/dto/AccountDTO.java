package com.example.spring_bank.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class AccountDTO {

    private Long accountId;
   
    private Long Id; //MemberEntity 참조
   
    private String accountNumber;
   
    private BigDecimal accountMoney;
   
    private Timestamp accountCreateAt;
   
    private Timestamp accountUpdateAt;

}
