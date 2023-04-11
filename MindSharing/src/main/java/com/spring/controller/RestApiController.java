package com.spring.controller;

import com.spring.Service.ApiService;
import com.spring.entity.ApiTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class RestApiController {

    @Autowired
    private ApiService apiService;

    @PostMapping
    public void addTests(@RequestBody ApiTest apiTest) {
        apiService.addTest(apiTest);
        System.out.println("apiTest 등록 완료");
    }

    @GetMapping("/list")
    public List<ApiTest> getTests() {
        return apiService.getTest();
    }

    // api/message 매핑으로 프론트에게 데이터를 보냄
    @GetMapping("/api/message")
    public ResponseEntity<Map<String, String>> getMessage() {
        Map<String, String> message = new HashMap<>();
        message.put("message", "Hello from Spring Boot!");

        return ResponseEntity.ok(message);
    }

}
