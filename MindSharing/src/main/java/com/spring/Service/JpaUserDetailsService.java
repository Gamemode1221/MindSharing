package com.spring.Service;

import com.spring.Repository.UserRepository;
import com.spring.entity.CustomUserDetails;
import com.spring.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JpaUserDetailsService implements UserDetailsService {
    // UserDetails 정보를 토대로 유저 정보를 불러올 때 사용됨.

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByUserId(username).orElseThrow(
            () -> new UsernameNotFoundException("Invaild Authentication!")
        );

        return new CustomUserDetails(user);
    }
}
