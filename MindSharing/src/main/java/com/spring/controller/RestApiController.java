package com.spring.controller;

import com.spring.Service.ApiService;
import com.spring.entity.ApiTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestApiController {

    // 생성자 주입
    private final ApiService apiService;

    public RestApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("api/user")
    public Map<String, String> getUser(@ModelAttribute String username, @ModelAttribute String email, @ModelAttribute String password) {

        Map<String, String> user = new HashMap<>();
        user.put("username", username);
        user.put("email", email);
        user.put("password", password);

        return user;
    }

//    // api/message 매핑으로 프론트에게 데이터를 보냄
//    @RequestMapping
//    public ResponseEntity<Map<String, String>> getMessage() {
//        Map<String, String> message = new HashMap<>();
//        message.put("message", "Hello from Spring Boot!");
//
//        return ResponseEntity.ok(message);
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


}
