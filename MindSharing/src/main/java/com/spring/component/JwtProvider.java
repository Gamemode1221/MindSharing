package com.spring.component;

import com.spring.Service.JpaUserDetailsService;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.Key;

@Component
@RequiredArgsConstructor
public class JwtProvider {

    // 참고 자료
    // https://velog.io/@junho5336/SpringBoot-%EB%A1%9C%EA%B7%B8%EC%9D%B8-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-with.-SpringSecurity-JWT

    @Value("${jwt.secret}")
    private String bread;

    @Value("${jwt.expiration}")
    private long expiration;

    private Key secretKey;

    private final JpaUserDetailsService jpaUserDetailsService;

    @PostConstruct
    protected void init() {
        secretKey = Keys.hmacShaKeyFor(bread.getBytes(StandardCharsets.UTF_8));
    }
}
