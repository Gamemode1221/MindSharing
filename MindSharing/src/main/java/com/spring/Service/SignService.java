package com.spring.Service;

import com.spring.Repository.UserRepository;
import com.spring.component.JwtProvider;
import com.spring.entity.Authority;
import com.spring.entity.User;
import com.spring.entity.dto.SignRequest;
import com.spring.entity.dto.SignResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class SignService {

    // 비즈니스 로직

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public SignResponse login(SignRequest request) throws Exception {
        User user = userRepository.findByUsername(request.getUsername()).orElseThrow(() ->
                new BadCredentialsException("잘못된 계정정보 입니다."));

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            throw new BadCredentialsException("잘못된 계정정보 입니다.");
        }

        return SignResponse.builder()
                .id(user.getId())
                .userId(user.getUserId())
                .username(user.getUsername())
                .userEmail(user.getEmail())
                .roles(user.getRoles())
                .token(jwtProvider.createToken(user.getUsername(), user.getRoles()))
                .build();
    }

    public boolean signup(SignRequest request) throws Exception {
        try {
            User user = User.builder()
                    .username(request.getUsername())
                    .password(passwordEncoder.encode(request.getPassword()))
                    .email(request.getUserEmail())
                    .build();

            user.setRoles(Collections.singletonList(Authority.builder().name("ROLE_USER").build()));

            userRepository.save(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("잘못된 요청입니다.");
        }
        return true;
    }

    public SignResponse getUser(String username) throws Exception {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new Exception("계정을 찾을 수 없습니다."));
        return new SignResponse(user);
    }
}
