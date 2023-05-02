package com.spring.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SignRequest {

    private Long id;

    private String username;

    private String password;

    private String email;

}

