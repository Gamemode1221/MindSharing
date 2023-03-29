package com.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TestController {

    @GetMapping
    public String root() {
//        TestJpa();
        return "TestHome";
    }

//    @Autowired
//    private UserRepository userRepository;
//
//    public void TestJpa() {
//        Test t1 = new Test();
//        t1.setPassword("aadsa");
//        t1.setName("asdsa");
//
//        this.userRepository.save(t1);  // 첫번째 질문 저장
//
//    }


}
