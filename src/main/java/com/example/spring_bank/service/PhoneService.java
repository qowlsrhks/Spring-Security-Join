package com.example.spring_bank.service;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@Service
public class PhoneService {

    @Value("${aligo.api.key}")
    private String apiKey;

    @Value("${aligo.user_id}")
    private String userId;

    @Value("${aligo.sender}")
    private String sender;

    private static final String ALIGO_SEND_URL = "https://apis.aligo.in/send/";

    public String sendSMS(String toPhoneNumber, String message) {
        RestTemplate restTemplate = new RestTemplate();
        Gson gson = new Gson();

        Map<String, String> params = new HashMap<>();
        params.put("key", apiKey);
        params.put("user_id", userId);
        params.put("sender", sender);
        params.put("receiver", toPhoneNumber);
        params.put("msg", message);

        return restTemplate.postForObject(ALIGO_SEND_URL, params, String.class);
    }

}