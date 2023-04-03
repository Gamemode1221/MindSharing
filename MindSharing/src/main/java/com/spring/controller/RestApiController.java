package com.spring.controller;

import com.spring.Service.ApiService;
import com.spring.Service.UserService;
import com.spring.entity.ApiTest;
import jakarta.persistence.Id;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RestApiController {

    @Autowired
    private ApiService apiService;

    @GetMapping("/apitest")
    public List<ApiTest> getTests() {
        return apiService.getTest();
    }

    @PostMapping("/apitest")
    public void addTests(@RequestBody ApiTest apiTest) {
        apiService.addTest(apiTest);
    }


}
