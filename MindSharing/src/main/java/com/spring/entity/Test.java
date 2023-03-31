package com.spring.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "test")
public class Test {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //ㅈㅏ동증가
    private Long id;

    @Column(unique = true)
    private String name;

    private String password;

    public Test() {
    }

}



