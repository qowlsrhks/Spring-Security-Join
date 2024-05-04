package com.example.spring_bank.service;

import com.example.spring_bank.dto.AccountDTO;
import com.example.spring_bank.entity.AccountEntity;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class AccountUtils {
    public static String generateAccountNumber() {
        Random random = new Random();
        int length = 10 + random.nextInt(7); // 10~16자리
        StringBuilder accountNumber = new StringBuilder();

        for (int i = 0; i < length; i++) {
            if (i == 6 || i == 8) accountNumber.append("-");
            int digit = random.nextInt(10); // 0~9 사이의 숫자
            accountNumber.append(digit);
        }

        return accountNumber.toString();
    }

    public AccountEntity saveAccountNum(AccountDTO accountDTO) {
        AccountEntity accountEntity = new AccountEntity();
        accountDTO.setAccountNumber(generateAccountNumber());
        accountEntity.setAccountNumber(accountDTO.getAccountNumber());
        return accountEntity;
    }
}
