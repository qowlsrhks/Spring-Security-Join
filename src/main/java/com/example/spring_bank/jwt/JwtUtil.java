package com.example.spring_bank.jwt;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;


public class JwtUtil {

    private  String secretKey = "verySecretKey";
    private  Key key = Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));

    //    Jwt생성
    public String generateToken(String memberEmail) {
        return Jwts.builder()
                .setSubject(memberEmail)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) //10시간
                .signWith(key)
                .compact();
    }

    public Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

}
