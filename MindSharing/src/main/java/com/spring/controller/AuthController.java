package com.spring.controller;

import com.spring.Service.JwtUtil;
import com.spring.Service.UserService;
import com.spring.entity.JwtRequest;
import com.spring.entity.JwtResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

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
        System.out.println("createAuthenticationToken Username : " + jwtRequest.getUsername());
        System.out.println("createAuthenticationToken Password : " + jwtRequest.getPassword());
        try {
            // 사용자 인증
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (UsernameNotFoundException e) {
            // 사용자를 찾지 못한 경우 응답을 변경하세요.
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
        } catch (RuntimeException e) {
            // 다른 예외가 발생한 경우, 여기에서 처리하세요.
        }

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
