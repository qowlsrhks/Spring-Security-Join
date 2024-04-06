package com.example.spring_bank.service;

import com.example.spring_bank.dto.AccountDTO;
import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.AccountEntity;
import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.repository.AccountRepository;
import com.example.spring_bank.repository.MemberRepository;
import com.example.spring_bank.role.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public void transferMoney(Long fromAccountId, Long toAccountId, BigDecimal amount) {
        AccountEntity fromAccount = accountRepository.findById(fromAccountId).orElseThrow();
        AccountEntity toAccount = accountRepository.findById(toAccountId).orElseThrow();

        fromAccount.setBalance(fromAccount.getBalance().subtract((amount)));
        toAccount.setBalance(toAccount.getBalance().add(amount));


        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }
}
