package com.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Team {

    @Id
    private Long teamId;
    private String teamName;
    private Long ownerId;
    private String memberId;
    private Long mapId;
    private String notice;
    private String favoriteUsers;

    public Team() { }

    public Team(Long teamId, String teamName, Long ownerId, String memberId, Long mapId, String notice, String favoriteUsers) {
        this.teamId = teamId;
        this.teamName = teamName;
        this.ownerId = ownerId;
        this.memberId = memberId;
        this.mapId = mapId;
        this.notice = notice;
        this.favoriteUsers = favoriteUsers;
    }
}
