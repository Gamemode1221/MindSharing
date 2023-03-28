package com.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter @Setter
public class Nodes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nodeId;

    private Long mapId;
    private Long userId;
    private Long parentId;
    private Long likes;
    private String detail;
    private Date modifyDate;
    private Long modifyUser;

    public Nodes() {
    }

    public Nodes(Long mapId, Long userId, Long parentId, Long likes, String detail, Date modifyDate, Long modifyUser) {
        this.mapId = mapId;
        this.userId = userId;
        this.parentId = parentId;
        this.likes = likes;
        this.detail = detail;
        this.modifyDate = modifyDate;
        this.modifyUser = modifyUser;
    }
}
