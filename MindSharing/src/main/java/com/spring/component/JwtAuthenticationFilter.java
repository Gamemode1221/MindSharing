package com.spring.component;

import com.spring.config.SecurityConfig;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtProvider jwtProvider;
    private final AuthenticationEntryPoint authenticationEntryPoint;
//    private final AccessDeniedHandler accessDeniedHandler;

    public JwtAuthenticationFilter(JwtProvider jwtProvider) {
        this.jwtProvider = jwtProvider;
//        this.accessDeniedHandler = (request, response, accessDeniedException) -> {
//            // 권한 문제가 발생했을 때 이 부분을 호출함
//            response.setStatus(403);
//            response.setCharacterEncoding("utf-8");
//            response.setContentType("text/html; charset=UTF-8");
//            response.getWriter().write("권한이 없는 사용자입니다.");
//        };
        this.authenticationEntryPoint = (request, response, authException) -> {
            // 인증 문제가 발생했을 때 이 부분을 호출함
            response.setStatus(401);
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html; charset=UTF-8");
            response.getWriter().write("인증되지 않은 사용자입니다.");
        };
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        RequestMatcher h2ConsoleMatcher = SecurityConfig.h2ConsoleMatcher();

        if (h2ConsoleMatcher.matches(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        try {
            String token = jwtProvider.resolveToken(request);

            if (token != null && jwtProvider.validateToken(token)) {
                // 토큰 검사
                token = token.split(" ")[1].trim();
                Authentication auth = jwtProvider.getAuthentication(token);
                SecurityContextHolder.getContext().setAuthentication(auth);
                filterChain.doFilter(request, response);
            } else {
                // 토큰이 없거나 유효하지 않은 경우
                authenticationEntryPoint.commence(request, response, new AuthenticationException("JWT token is not valid") {
                });
            }

        } catch (JwtException e) {
            authenticationEntryPoint.commence(request, response, new AuthenticationException("JWT token is not valid") {
            });
        }
    }
}
