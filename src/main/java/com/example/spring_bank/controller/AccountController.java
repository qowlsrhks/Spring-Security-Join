package com.example.spring_bank.controller;

import com.example.spring_bank.dto.AccountDTO;
import com.example.spring_bank.dto.TransactionDTO;
import com.example.spring_bank.entity.AccountEntity;
import com.example.spring_bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class AccountController {
    private final AccountService accountService;

    //    계좌이체 화면
    @GetMapping("account_success")
    public String accountHome(Model model) {
        model.addAttribute("transactionDTO", new TransactionDTO());
        return "account_success";
    }
    

//    계좌 생성 페이지
    @GetMapping("account_create_page")
    public String accountNumCreateHome(Model model) {
        model.addAttribute("accountDTO", new AccountDTO());
        return "/account_create_page";
    }

//    계좌생성
    @PostMapping("account_num_create")
    public AccountEntity accountNumCreate(@RequestBody AccountDTO accountDTO) {
        return accountService.createAndSaveAccount(accountDTO);
    }
}
