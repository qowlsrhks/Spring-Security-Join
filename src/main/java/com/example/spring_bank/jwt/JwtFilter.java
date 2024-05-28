package com.example.spring_bank.jwt;

import com.example.spring_bank.entity.MemberEntity;
import com.example.spring_bank.service.CustomUserDetails;
import com.example.spring_bank.service.CustomUserDetailsService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    public JwtFilter(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

//        request에서 Authorization 헤더를 찾음
        String authorization = request.getHeader("Authorization");

//        Authorization 헤더 검증
        if (authorization == null || !authorization.startsWith("Bearer ")) {
            System.out.println("token null");
            filterChain.doFilter(request,response);

//            조건이 해당되면 메소드 종료(필수)
            return;
        }
        String token = authorization.split(" ")[1];

//        토큰 소멸 시간 검증
        if (jwtUtil.isExpired(token)) {
            System.out.println("token expired");
            filterChain.doFilter(request, response);
            return;
        }

        String memberEmail = jwtUtil.getUsername(token);
        String memberRole = jwtUtil.getRole(token);

        MemberEntity memberEntity = new MemberEntity();
        memberEntity.setMemberEmail(memberEmail);
        memberEntity.setMemberPw("$2a$10$zmpCRZ0peK5084BS83FXO.l5LWeRakvGG4wTe.DqSjsqoFdItPQBC");
        memberEntity.setMemberRole(memberRole);

        CustomUserDetails customUserDetails = new CustomUserDetails(memberEntity);
        Authentication authtoken = new UsernamePasswordAuthenticationToken(customUserDetails, null, customUserDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authtoken);
        filterChain.doFilter(request,response);
    }
}
