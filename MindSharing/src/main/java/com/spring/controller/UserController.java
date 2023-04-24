package com.spring.controller;

import com.spring.Service.BaseException;
import com.spring.Service.UserService;
import com.spring.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class UserController {

    // 사용자 로그인 및 회원가입 유효성 검사 코드 추가 필요

    // 생성자 주입
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @PostMapping("/signup")
    public ResponseEntity<String> addUser(@RequestBody Map<String, String> payload) {

        String username = payload.get("username");
        String email = payload.get("useremail");
        String password = payload.get("password");

//        System.out.println("username : " + username);
//        System.out.println("email : " + email);
//        System.out.println("password : " + password);

        userService.signup(username, email, password);

        return ResponseEntity.ok("유저 회원가입 완료");
    }

//    @PostMapping("/login")
//    @ResponseBody
//    public String login() {
//        return "로그인 완료";
//    }

    @GetMapping("/user/list")
    @ResponseBody
    public List<User> getUsers() {

        List<User> users = userService.getUsers();

        if (users == null) return null;

        return userService.getUsers();
    }

    @ResponseBody
    @GetMapping("/home")
    public void kakaoCallback(@RequestParam String code) throws BaseException {
        String access_Token = userService.getKaKaoAccessToken(code);
        userService.createKakaoUser(access_Token);
    }
}

