package com.example.spring_bank.controller;

import com.example.spring_bank.dto.AccountDTO;
import com.example.spring_bank.dto.TransactionDTO;
import com.example.spring_bank.entity.AccountEntity;
import com.example.spring_bank.service.AccountService;
import com.example.spring_bank.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AccountController {
    private final TransactionService transactionService;

    //    계좌이체 화면
    @GetMapping("account_success")
    public String accountHome(Model model) {
        model.addAttribute("transactionDTO", new TransactionDTO());
        return "account_success";
    }

    @PostMapping("account_send")
    public ResponseEntity<String> transfer(@ModelAttribute TransactionDTO tra) {
        transactionService.transfer(tra.getFromAccountId(), tra.getToAccountId(), tra.getTransactionAmount());
        return ResponseEntity.ok("Transfer successful");
    }

}
