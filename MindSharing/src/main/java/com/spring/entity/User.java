package com.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity(name = "users")
@Getter @Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userId;
    private String password;
    private String email;
    private String username;
    private String userStatus;
    private Date joinDate;
    private String blogUrl;
    private String githubUrl;
    private String favoriteTeams;

    public User() { }

    public User(String userId, String password, String email, String username, String userStatus, Date joinDate, String blogUrl, String githubUrl, String favoriteTeams) {
        this.userId = userId;
        this.password = password;
        this.email = email;
        this.username = username;
        this.userStatus = userStatus;
        this.joinDate = joinDate;
        this.blogUrl = blogUrl;
        this.githubUrl = githubUrl;
        this.favoriteTeams = favoriteTeams;
    }
}
