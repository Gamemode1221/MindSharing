package com.spring.Service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private long expiration;

    // JWT 생성
    public String generateToken(UserDetails userDetails) {
        // ... 코드 작성

        return null;
    }

    // JWT 유효성 검사
    public boolean validateToken(String token, UserDetails userDetails) {
        // ... 코드 작성

        return false;
    }

    // JWT에서 사용자 정보 추출
    public String getUsernameFromToken(String token) {
        // ... 코드 작성

        return null;
    }
}
