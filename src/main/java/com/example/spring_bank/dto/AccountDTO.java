package com.example.spring_bank.dto;

import com.example.spring_bank.entity.AccountEntity;
import com.example.spring_bank.entity.MemberEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    private Long accountId;
   
    private String accountMemberEmail; //MemberEntity 참조
   
    private String accountNumber;
   
    private BigDecimal accountMoney;
   
    private Timestamp accountCreateAt;
   
    private Timestamp accountUpdateAt;

}
