package com.spring.entity;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class User {
    private String username;
    private String password;
    private String userRole;

    public User(String username, String password, String userRole) {
        this.username = username;
        this.password = password;
        this.userRole = userRole;
    }
}
