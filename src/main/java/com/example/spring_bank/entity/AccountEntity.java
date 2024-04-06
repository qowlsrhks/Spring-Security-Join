package com.example.spring_bank.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import java.lang.reflect.Member;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "TBL_ACCOUNT")
public class AccountEntity {

    //  계좌이체 열
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_num")
    private Long accountNum;

    private BigDecimal balance; // 잔액

    @OneToMany(mappedBy = "memberId")
    private List<MemberEntity> members = new ArrayList<>();



}

