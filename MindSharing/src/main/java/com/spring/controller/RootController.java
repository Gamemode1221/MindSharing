package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class RootController {

    @GetMapping
    public String root() {
//        return "TestHome"; // Test 용 Home
        return "";
    }

    @GetMapping("/login")
//    @ResponseBody
    public String login() {
        return "";
    }

    @GetMapping("/signup")
//    @ResponseBody
    public String signup() {
        return "";
    }

    @GetMapping("/mypage")
//    @ResponseBody
    public String myPage() {
        return "";
    }

    @GetMapping("/team")
//    @ResponseBody
    public String team() {
        return "";
    }

    @GetMapping("/setting")
//    @ResponseBody
    public String setting() {
        return "";
    }
}
