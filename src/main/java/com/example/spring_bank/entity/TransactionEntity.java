package com.example.spring_bank.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "TBL_TRANS")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

//    accountEntnty참조해서 id찾기
    @ManyToOne
    @JoinColumn(name = "from_account_num", nullable = false)
    private AccountEntity fromAccountNum;
//    accountEntity 참조 위와 동일
    @ManyToOne
    @JoinColumn(name = "to_account_num", nullable = false)
    private AccountEntity toAccountNum;
    
//    이체 금액
    @Column(name = "transaction_amount", nullable = false)
    private BigDecimal transactionAmount;
    
//    계좌 이체 기록 날짜
    @CreationTimestamp
    @Column(name = "transaction_created_at")
    private Timestamp transactionCreateAt;

//    성공 실패 여부
    @Column(name = "transaction_status", nullable = false)
    private String transactionStatus;
}
