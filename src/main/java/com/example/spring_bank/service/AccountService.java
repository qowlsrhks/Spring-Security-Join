package com.example.spring_bank.service;

import com.example.spring_bank.dto.AccountDTO;
import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.AccountEntity;
import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.repository.AccountRepository;
import com.example.spring_bank.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;


@Service
@RequiredArgsConstructor
public class AccountService {


    private final AccountRepository accountRepository;
    private final MemberRepository memberRepository;



    @Transactional
    public AccountEntity createAccountNum(AccountEntity accountEntity) {
        MemberEntity memberEntity = memberRepository.findByMemberId(accountEntity.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("사용자를 찾을 수 없습니다"));

        AccountUtils utils = new AccountUtils();
        accountEntity.setMemberId(memberEntity);
        accountEntity.setAccountNumber(utils.generateAccountNumber());
        accountEntity.setAccountMoney(accountEntity.getAccountMoney());
        return accountRepository.save(accountEntity);
    }


}
