package com.example.spring_bank.service;

import com.example.spring_bank.dto.AccountDTO;
import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.AccountEntity;
import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.repository.AccountRepository;
import com.example.spring_bank.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Member;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
@Slf4j
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountEntity createAndSaveAccount(AccountDTO accountDTO) {
        AccountEntity accountEntity = new AccountEntity();
        MemberEntity memberEntity = new MemberEntity();
        AccountUtils accountUtils = new AccountUtils();

        accountEntity.setAccountMemberId(memberEntity);
        accountUtils.saveAccountNum(accountDTO);
        accountEntity.setAccountMoney(BigDecimal.ZERO);
        accountEntity.setAccountCreateAt(Timestamp.from(Instant.now()));
        accountEntity.setAccountUpdateAt(Timestamp.from(Instant.now()));

        return accountRepository.save(accountEntity);
    }
}
