package com.example.spring_bank.dto;

import com.example.spring_bank.entity.AccountEntity;
import com.example.spring_bank.entity.MemberEntity;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class AccountDTO {

    private Long accountId;
   
    private MemberEntity memberId; //MemberEntity 참조
   
    private String accountNumber;
   
    private BigDecimal accountMoney;
   
    private Timestamp accountCreateAt;
   
    private Timestamp accountUpdateAt;

}
