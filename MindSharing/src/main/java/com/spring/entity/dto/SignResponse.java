package com.spring.entity.dto;

import com.spring.entity.Authority;
import com.spring.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SignResponse {

    private Long id;

    private String username;

    private String userEmail;

    private List<Authority> roles = new ArrayList<>();

    private String token;

//    private String userStatus;
//    private Date joinDate;
//    private String blogUrl;
//    private String githubUrl;
//    private String favoriteTeams;


    public SignResponse(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.userEmail = user.getEmail();
        this.roles = user.getRoles();
    }
}
