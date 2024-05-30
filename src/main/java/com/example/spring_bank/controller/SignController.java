package com.example.spring_bank.controller;

import com.example.spring_bank.dto.AuthResponse;
import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.jwt.JwtUtil;
import com.example.spring_bank.service.CustomUserDetailsService;
import com.nimbusds.openid.connect.sdk.AuthenticationResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    @ResponseBody
    public String createAuthenticationToken(@RequestBody MemberDTO memberDTO) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(memberDTO.getMemberEmail(), memberDTO.getMemberPw())
            );
        } catch (AuthenticationException e) {
            throw new Exception("Incorrect memberEmail or memberPw", e);
        }

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(memberDTO.getMemberEmail());

        return jwtUtil.generateToken(userDetails.getUsername());

    }
}
