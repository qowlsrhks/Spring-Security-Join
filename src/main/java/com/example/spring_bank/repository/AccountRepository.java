package com.example.spring_bank.repository;

import com.example.spring_bank.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByAccountNumber(AccountEntity accountNumber);

    Optional<AccountEntity> findByAccountMoney(BigDecimal accountMoney);



}