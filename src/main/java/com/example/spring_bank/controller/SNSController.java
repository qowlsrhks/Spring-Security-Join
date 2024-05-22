package com.example.spring_bank.controller;

import com.example.spring_bank.service.PhoneService;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class SNSController {


    private final PhoneService smsService;

    public SNSController(PhoneService smsService) {
        this.smsService = smsService;
    }

    @PostMapping("/sendSMS")
    public String sendSMS(@RequestParam String memberPhone) {
        // 인증 코드를 생성합니다 (예: 6자리 랜덤 숫자)
        String authCode = String.format("%06d", (int)(Math.random() * 1000000));

        String message = "Your verification code is: " + authCode;
        String response = smsService.sendSMS(memberPhone, message);

        // 실제 응용 프로그램에서는 인증 코드를 데이터베이스에 저장하고 만료 시간을 설정합니다.
        // 이 예제에서는 간단히 메시지를 반환합니다.
        return "SMS sent successfully! Response: " + response;
    }

}
