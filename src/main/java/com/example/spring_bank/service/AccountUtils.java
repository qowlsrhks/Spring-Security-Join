package com.example.spring_bank.service;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AccountUtils {
    public String generateAccountNumber() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        return sdf.format(new Date());
    }
}
