package com.example.spring_bank.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class JwtUtil {

    private final String secretKey = "202020";
    private final Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));

    //    Jwt생성
    @Bean
    public String generateToken(String memberEmail) {
        return Jwts.builder()
                .setSubject(memberEmail)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) //10시간
                .signWith(key)
                .compact();
    }

    @Bean
    public Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
