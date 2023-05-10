package com.spring.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class gptapiController {
    @RequestMapping("/test")
    public @ResponseBody String test() {
        return "test";
    }
}
