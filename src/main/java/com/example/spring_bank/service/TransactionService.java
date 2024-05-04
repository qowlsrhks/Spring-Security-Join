package com.example.spring_bank.service;

import com.example.spring_bank.dto.AccountDTO;
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

}
