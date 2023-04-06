package com.spring.controller;

import com.spring.Service.ApiService;
import com.spring.entity.ApiTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api")
public class RestApiController {

    @Autowired
    private ApiService apiService;

//    @GetMapping("/test")
//    public String test() {
//        return "test page";
//    }

//    @PostMapping("/test")
//    public void addTests(@RequestBody ApiTest apiTest) {
//        apiService.addTest(apiTest);
//    }

//    @GetMapping("/test/list")
    public List<ApiTest> getTests() {
        return apiService.getTest();
    }

//    @GetMapping("/test/list")
//    @ResponseBody
//    public String testList() {
//        return apiService.getTest().toString();
//    }

}
