package com.example.spring_bank.controller;

import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.jwt.JwtUtil;
import com.example.spring_bank.service.CustomUserDetailsService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@Controller
public class SignController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final CustomUserDetailsService userDetailsService;

    public SignController(AuthenticationManager authenticationManager, JwtUtil jwtUtil, CustomUserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }


    //    로그인 화면
    @GetMapping("sign")
    public String showSignForm() {
        return "/sign";
    }

    //    로그인 검증
    @PostMapping("authenticate")
    public ResponseEntity<String> login(@RequestBody MemberDTO memberDTO, HttpServletResponse response) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(memberDTO.getMemberEmail(), memberDTO.getMemberPw())
            );
            final UserDetails userDetails = userDetailsService.loadUserByUsername(memberDTO.getMemberEmail());
            String token = jwtUtil.generateToken(userDetails.getUsername());
            response.addHeader("Authorization", "Bearer " + token);
            return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, "Bearer " + token).body("redirect:/home");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Authentication failed");
        }
    }
}
