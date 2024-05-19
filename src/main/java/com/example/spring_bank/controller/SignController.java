package com.example.spring_bank.controller;

import com.example.spring_bank.dto.AuthResponse;
import com.example.spring_bank.dto.LoginRequest;
import com.example.spring_bank.dto.MemberDTO;
import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.jwt.JwtUtil;
import com.example.spring_bank.jwt.LoginFilter;
import com.example.spring_bank.service.MemberService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/")
@Controller
public class SignController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public SignController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }


    //    로그인 화면
    @GetMapping("sign")
    public String showSignForm(Model model) {
        model.addAttribute("memberDTO", new MemberDTO());
        return "/sign";
    }

    //    로그인 검증
    @PostMapping("sign_form")
    @ResponseBody
    public ResponseEntity<?> signMember(@RequestBody LoginRequest loginRequest ) {
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getMemberEmail(),
                            loginRequest.getMemberPw()
                    )
            );
            String token = jwtUtil.generateToken(authentication.getName());
            return ResponseEntity.ok().body(new AuthResponse(token));
        }catch (Exception e){
            return ResponseEntity.badRequest().body("로그인 실패");
        }
    }
}
