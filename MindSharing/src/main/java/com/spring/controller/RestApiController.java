package com.spring.controller;

import com.spring.Service.ApiService;
import com.spring.entity.ApiTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class RestApiController {

    @Autowired
    private ApiService apiService;

//    @GetMapping("/test")
//    public String test() {
//        return "test page";
//    }

    @PostMapping
    public void addTests(@RequestBody ApiTest apiTest) {
        apiService.addTest(apiTest);
        System.out.println("apiTest 등록 완료");
    }

    @GetMapping("/list")
    public List<ApiTest> getTests() {
        return apiService.getTest();
    }

//    @GetMapping("/test/list")
//    @ResponseBody
//    public String testList() {
//        return apiService.getTest().toString();
//    }

}
