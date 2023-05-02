package com.spring.controller;

import com.spring.Service.ApiService;
import com.spring.Service.SignService;
import com.spring.Service.UserService;
import com.spring.component.JwtProvider;
import com.spring.entity.ApiTest;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
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
    private final JwtProvider jwtProvider;

    public RestApiController(ApiService apiService, UserService userService, SignService signService, JwtProvider jwtProvider) {
        this.apiService = apiService;
        this.userService = userService;
        this.signService = signService;
        this.jwtProvider = jwtProvider;
    }

    @PostMapping("api/user")
    public Map<String, String> getUser(Authentication authentication, HttpServletRequest request) {

        // 사용자의 로그인 토큰을 받아와서 UserService의 loadUserByUsername() 메소드를 통해 유저의 정보를 알아내고
        // 그 유저의 정보를 User 클래스의 Map 형식으로 리턴.

//        HashMap<String, String> user = signService.getUser();

        String token = jwtProvider.resolveToken(request);

        UserDetails details = jwtProvider.getUserDetailsFromToken(token);

//        HashMap<String, String> user = signService.getUser(details.getUsername());


        return null;
    }

//    public UserDetails getCurrentUser(Authentication authentication, HttpServletRequest request) {
//        // 현재 인증된 사용자의 JWT 토큰을 가져옵니다.
//        String token = jwtProvider.resolveToken(request);
//
//        // 토큰에서 사용자 정보를 가져옵니다.
//        UserDetails userDetails = jwtProvider.getUserDetailsFromToken(token);
//
//        return userDetails;
//    }

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
