package com.spring.controller;

import com.spring.Service.ApiService;
import com.spring.Service.SignService;
import com.spring.Service.UserService;
import com.spring.entity.ApiTest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
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
    private final SignService signService;

    public RestApiController(ApiService apiService, UserService userService, SignService signService) {
        this.apiService = apiService;
        this.userService = userService;
        this.signService = signService;
    }

    @PostMapping("api/user")
    public Map<String, String> getUser(Authentication authentication, HttpServletRequest request) throws Exception {

        // 현재 접속중인 사용자의 토큰을 받음
//        String token = jwtProvider.resolveToken(request);

//        System.out.println("token : " + token);

        // 사용자의 토큰에서 사용자의 아이디 추출
//        UserDetails details = jwtProvider.getUserDetailsFromToken(token);

        // 사용자의 아이디로 사용자의 모든 정보 추출
//        User userInfo = signService.getUserInfo(details.getUsername());

        Map<String, String> user = new HashMap<>();

//        user.put("username", userInfo.getUsername());
//        user.put("email", userInfo.getEmail());
//        user.put("status", userInfo.getUserStatus());
//        user.put("joindate", userInfo.getJoinDate().toString());
//        user.put("blog", userInfo.getBlogUrl());
//        user.put("github", userInfo.getGithubUrl());
//        user.put("favoriteteam", userInfo.getFavoriteTeams());

        System.out.println(user);

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

    @RequestMapping("/check")
    public void isLoggedIn(HttpServletRequest request) {
//        System.out.println("ApplicationController isLoggedIn() token : " + jwtProvider.resolveToken(request));
    }

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
