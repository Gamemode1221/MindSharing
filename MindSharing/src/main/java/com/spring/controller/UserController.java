//package com.spring.controller;
//
//import ch.qos.logback.core.model.Model;
//import com.spring.entity.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class UserController {
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/signup")
//    public String showSignUpForm(Model model) {
//        model.addAttribute("user", new User());
//        return "signup";
//    }
//
//    @PostMapping("/signup")
//    public String signUp(@ModelAttribute("user") User user) {
//        userService.save(user);
//        return "redirect:/login";
//    }
//
//    @GetMapping("/login")
//    public String showLoginForm() {
//        return "login";
//    }
//}
//
