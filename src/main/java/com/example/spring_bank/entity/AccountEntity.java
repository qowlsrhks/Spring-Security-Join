package com.example.spring_bank.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.lang.reflect.Member;
import java.math.BigDecimal;
import java.sql.Timestamp;
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
    @Column(name = "account_id")
    private Long accountId;

//    memberEntity 참조
    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private MemberEntity memberId;
    
//    계좌 번호
    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;
    
//    계좌에 들어있는 돈
    @Column(name = "account_money", precision = 15, scale = 2, nullable = false)
    private BigDecimal accountMoney;

//    계좌 생성 날짜
    @CreationTimestamp
    @Column(name = "account_create_at",nullable = false)
    private Timestamp accountCreateAt;

//    계좌 업데이트 날짜
    @UpdateTimestamp
    @Column(name = "acount_update_at")
    private Timestamp accountUpdateAt;
}

