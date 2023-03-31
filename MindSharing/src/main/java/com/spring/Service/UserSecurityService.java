package com.spring.Service;

import com.spring.Repository.UserRepository;
import com.spring.entity.Test;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserSecurityService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override // loadUserByUsername 메서드에 의해 리턴된 User 객체(리턴)의 비밀번호가 화면으로부터 입력 받은 비밀번호와 일치하는지를 검사하는 로직
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Test> test1 = this.userRepository.findByname(username);
        if (test1.isEmpty()) {
            throw new UsernameNotFoundException("사용자를 찾을수 없음요.");
        }
        Test test = test1.get();
        List<GrantedAuthority> authorities = new ArrayList<>();

        if ("admin".equals(username)) { //name이 admin이면 ADMIN 권한 부여 아니면 USER 권한 부여
            authorities.add(new SimpleGrantedAuthority(UserRole.ADMIN.getValue()));
        } else {
            authorities.add(new SimpleGrantedAuthority(UserRole.USER.getValue()));
        }

        //name, password, 권한을 입력으로 스프링 시큐리티의 User 객체를 생성하여 리턴
        return new User(test.getName(), test.getPassword(), authorities);
    }
}