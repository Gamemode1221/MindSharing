package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApplicationController {

//    private final JwtProvider jwtProvider;
//
//    public ApplicationController(JwtProvider jwtProvider) {
//        this.jwtProvider = jwtProvider;
//    }

    @RequestMapping(value = "/{path:[^\\.]*}")
    public String redirect() {
        return "forward:/";
    }

//    @RequestMapping("/")
//    public void isLoggedIn(HttpServletRequest request) {
//        System.out.println("ApplicationController isLoggedIn() token : " + jwtProvider.resolveToken(request));
//    }
}
