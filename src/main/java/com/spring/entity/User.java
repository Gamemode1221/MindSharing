package com.spring.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.*;
import lombok.Builder;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity(name = "users")
@Getter @Setter @Builder
@AllArgsConstructor
//@NoArgsConstructor
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class User {
    // 사용자 정의 클래스

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(unique = true)
    private String email;

//    private String username;
    private String userStatus;

    private Date joinDate;

    private String blogUrl;
    private String githubUrl;
    private String favoriteTeams;

    private String role;

    public User() { }

    public User(String username, String password, String email, String userStatus, Date joinDate, String blogUrl, String githubUrl, String favoriteTeams) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.userStatus = userStatus;
        this.joinDate = joinDate;
        this.blogUrl = blogUrl;
        this.githubUrl = githubUrl;
        this.favoriteTeams = favoriteTeams;
    }

    // 임시
    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    //    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    @Builder.Default
//    private List<Authority> roles = new ArrayList<>();
//
//    public void setRoles(List<Authority> role) {
//        this.roles = role;
//        role.forEach(o -> o.setUser(this));
//    }
}
