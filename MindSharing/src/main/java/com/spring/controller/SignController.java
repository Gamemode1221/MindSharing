package com.spring.controller;

import com.spring.Repository.UserRepository;
import com.spring.Service.SignService;
import com.spring.component.JwtProvider;
import com.spring.entity.User;
import com.spring.entity.dto.SignRequest;
import com.spring.entity.dto.SignResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class SignController {

    private final UserRepository userRepository;
    private final SignService userService;
    private final JwtProvider jwtProvider;

    @PostMapping("/login")
    public ResponseEntity<SignResponse> signIn(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(userService.login(request), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<Boolean> signup(@RequestBody SignRequest request) throws Exception {
        return new ResponseEntity<>(userService.signup(request), HttpStatus.OK);
    }

    @GetMapping("/user/get")
    public ResponseEntity<?> getUser(@RequestParam String username, HttpServletRequest request) throws Exception {
        String token = jwtProvider.resolveToken(request);

//        if (token == null || !jwtProvider.validateToken(token)) {
//            return new ResponseEntity<>("인증되지 않은 사용자입니다. (SignController.getUser())", HttpStatus.UNAUTHORIZED);
//        }

        SignResponse user = userService.getUser(username);
        SignResponse response = SignResponse.builder()
                .id(user.getId())
                .email(user.getEmail())
                .roles(user.getRoles())
                .token(token)
                .build();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/admin/get")
    public ResponseEntity<SignResponse> getUserForAdmin(@RequestBody String username) throws Exception {
        return new ResponseEntity<>(userService.getUser(username), HttpStatus.OK);
    }
}
