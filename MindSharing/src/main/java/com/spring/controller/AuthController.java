package com.spring.controller;

import com.spring.Service.JwtUtil;
import com.spring.Service.UserService;
import com.spring.entity.JwtRequest;
import com.spring.entity.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest jwtRequest) {
        // 사용자 인증
        authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

        // JWT 발급
        final UserDetails userDetails = userService.loadUserByUsername(jwtRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        // JWT 반환
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    private void authenticate(String username, String password) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException | BadCredentialsException e) {
            throw new RuntimeException(e);
        }
    }
}
