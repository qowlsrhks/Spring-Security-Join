package com.example.spring_bank.service;

import com.example.spring_bank.dto.TransactionDTO;
import com.example.spring_bank.entity.AccountEntity;
import com.example.spring_bank.entity.TransactionEntity;
import com.example.spring_bank.repository.AccountRepository;
import com.example.spring_bank.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class TransactionService {

    private final AccountRepository accountRepository;

    @Transactional
    public boolean transfer(String fromAccountNum, String toAccountNum, BigDecimal amount) {
        AccountEntity fromAccount = accountRepository.findByAccountNumber(fromAccountNum)
                .orElseThrow(() -> new IllegalArgumentException("출금 계좌를 찾을 수 없습니다"));
        AccountEntity toAccount = accountRepository.findByAccountNumber(toAccountNum)
                .orElseThrow(() -> new IllegalArgumentException("입금 계좌를 찾을 수 없습니다"));

        if (fromAccount.getAccountMoney().compareTo(amount) < 0) {
            throw new IllegalArgumentException("잔액이 부족합니다.");
        }

        fromAccount.setAccountMoney(fromAccount.getAccountMoney().subtract(amount));
        toAccount.setAccountMoney(toAccount.getAccountMoney().add(amount));

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        return true;
    }



}
