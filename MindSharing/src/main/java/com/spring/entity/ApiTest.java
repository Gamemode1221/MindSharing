package com.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//@Entity
//@Getter @Setter
public class ApiTest {

//    @Id
    private Long id;

    private String text1;
    private String text2;
    private String text3;

    public ApiTest() {
    }

    public ApiTest(String text1, String text2, String text3) {
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
    }
}
