//package com.spring.controller;
//
//import com.spring.Service.OpenAIService;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.client.HttpClientErrorException;
//
//@Slf4j
//@RestController
//@RequestMapping("api")
//public class openAIController {
//    @Autowired
//    private OpenAIService openAIService;
//
//    @GetMapping("/ai")
//    public ResponseEntity<?> openAiGPT(@RequestParam(required = false) String query, @RequestParam(required = false) String sort, @RequestParam(required = false) int display) {
//        try {
//            return ResponseEntity.ok().body(openAIService.getCompletion("안녕"));
//        } catch (HttpClientErrorException e) {
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//    }
//}