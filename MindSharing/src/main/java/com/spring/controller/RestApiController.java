package com.spring.controller;

import com.spring.Service.ApiService;
import com.spring.Service.UserService;
import com.spring.entity.ApiTest;
import com.spring.entity.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class RestApiController {

    // 클라이언트에게 웅답을 반환할 때에는 HTTP 상태 코드와 JSON 형식을 함께 사용하는 것이 좋음.
    // 클라이언트 측에서 응답을 쉽게 처리할 수 있고, 보다 명확한 에러 처리 및 디버깅이 가능함.

    // 생성자 주입
    private final ApiService apiService;
    private final UserService userService;

    public RestApiController(ApiService apiService, UserService userService) {
        this.apiService = apiService;
        this.userService = userService;
    }

    @PostMapping("api/user")
    public Map<String, String> getUser(@ModelAttribute User user) {

        // 사용자의 로그인 토큰을 받아와서 UserService의 loadUserByUsername() 메소드를 통해 유저의 정보를 알아내고
        // 그 유저의 정보를 User 클래스의 Map 형식으로 리턴.

//        Map<String, String> user = new HashMap<>();
//        user.put("username", username);
//        user.put("email", email);
//        user.put("password", password);
//
//        return user;

        return null;
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
