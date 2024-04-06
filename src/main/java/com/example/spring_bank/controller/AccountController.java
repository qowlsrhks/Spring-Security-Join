package com.example.spring_bank.controller;

import com.example.spring_bank.dto.AccountDTO;
import com.example.spring_bank.entity.AccountEntity;
import com.example.spring_bank.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
@RequiredArgsConstructor
public class AccountController {
    private final AccountService accountService;

    //    계좌이체 화면
    @GetMapping("account_success")
    public String accountHome(Model model) {
        model.addAttribute("accountDTO", new AccountDTO());
        return "account_success";
    }

    @PostMapping("account_send")
    public ResponseEntity<String> transfer(@ModelAttribute  AccountDTO accountDTO) {
        accountService.transferMoney(accountDTO.getFromMemberId(),accountDTO.getToMemberId(),accountDTO.getAmount());
        return ResponseEntity.ok("Transfer successful");
    }

}
