package com.spring.Service;

import com.spring.Repository.UserRepository;
import com.spring.entity.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder; //빈으로 객체를 받아오게끔

    public Test create(String name1, String password) {
        Test test = new Test();
        test.setNickname(name1);
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder(); //시큐리티의 암호화
        test.setPassword(passwordEncoder.encode(password));
        this.userRepository.save(test);
        return test;
    }
}
