package com.spring.component;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    // final 형으로 바꿔도 괜찮음.
    private JwtProvider provider;
    private UserDetailsService userDetailsService;

    public JwtAuthenticationFilter(JwtProvider provider, UserDetailsService userDetailsService) {
        this.provider = provider;
        this.userDetailsService = userDetailsService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getJwtFromRequest(request);

            if (jwt != null && provider.validateToken(jwt)) {
                Long userId = provider.getUserIdFromJWT(jwt);

                UserDetails userDetails = userDetailsService.loadUserByUsername(String.valueOf(userId));
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

//
//    private final JwtProvider jwtProvider;
//    private final AuthenticationEntryPoint authenticationEntryPoint;
////    private final AccessDeniedHandler accessDeniedHandler; // 이미 SecurityConfig에 접속 설정이 있음.
//
//    public JwtAuthenticationFilter(JwtProvider jwtProvider) {
//        this.jwtProvider = jwtProvider;
////        this.accessDeniedHandler = (request, response, accessDeniedException) -> {
////            // 권한 문제가 발생했을 때 이 부분을 호출함
////            response.setStatus(403);
////            response.setCharacterEncoding("utf-8");
////            response.setContentType("text/html; charset=UTF-8");
////            response.getWriter().write("권한이 없는 사용자입니다.");
////        };
//        this.authenticationEntryPoint = (request, response, authException) -> {
//            // 인증 문제가 발생했을 때 이 부분을 호출함
//            response.setStatus(401);
//            response.setCharacterEncoding("utf-8");
//            response.setContentType("text/html; charset=UTF-8");
////            response.getWriter().write("인증되지 않은 사용자입니다. (JwtAuthenticationFilter)");
//        };
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
////
////        RequestMatcher h2ConsoleMatcher = SecurityConfig.h2ConsoleMatcher();
////
////        if (h2ConsoleMatcher.matches(request)) {
////            filterChain.doFilter(request, response);
////            return;
////        }
////
////
////        try {
////            String token = jwtProvider.resolveToken(request);
////
////            if (token != null && jwtProvider.validateToken(token)) {
////                // 토큰 검사
////                token = token.split(" ")[1].trim();
////                Authentication auth = jwtProvider.getAuthentication(token);
////                SecurityContextHolder.getContext().setAuthentication(auth);
////            } else {
////                // 토큰이 없거나 유효하지 않은 경우
////                authenticationEntryPoint.commence(request, response, new AuthenticationException("JWT token is not valid") {
////                });
////            }
////            filterChain.doFilter(request, response);
////
////        } catch (JwtException e) {
////            authenticationEntryPoint.commence(request, response, new AuthenticationException("JWT token is not valid") {
////            });
////        }
//    }
}
