package com.spring.Service;

import com.spring.Repository.UserRepository;
import com.spring.entity.Users;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; //빈으로 객체를 받아오게끔

    public Users create(String username, String password) {
        Users user = new Users();
        user.setNickname(username);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //시큐리티의 암호화
        user.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(user);
        return user;
    }
}
