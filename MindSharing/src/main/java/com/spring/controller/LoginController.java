//package com.spring.controller;
//
//import com.spring.Service.LoginService;
//import com.spring.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/login")
//public class LoginController {
//
//    @Autowired
//    private LoginService loginService;
//
//    @PostMapping
//    public void addUser(@RequestBody User user) {
//        loginService.addUser(user);
//        System.out.println("유저 로그인 완료");
//    }
//
//    @GetMapping("/list")
//    public List<User> getUsers() {
//        return loginService.getUser();
//    }
//}
