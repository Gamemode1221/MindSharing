package com.spring.controller;

import com.spring.entity.Person;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @GetMapping("/myinfo")
    public Person getPerson() {
        Person person = new Person();
        person.setName("ㅇㅣ진아");
        person.setAge(22);
        person.setAddress("경기");
        person.setJob("대학생");
        return person;
    }
}
