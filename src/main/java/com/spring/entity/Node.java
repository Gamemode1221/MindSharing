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
public class Node {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nodeId;

    private Long mapId;
    private Long userId;
    private Long parentId;
    private Long likes;
    private String detail;
    private Date createDate;
    private Date modifyDate;
    private Long modifyUser;

    public Node() {
    }

    public Node(Long mapId, Long userId, Long parentId, Long likes, String detail, Date modifyDate, Long modifyUser, Date createDate) {
        this.mapId = mapId;
        this.userId = userId;
        this.parentId = parentId;
        this.likes = likes;
        this.detail = detail;
        this.modifyDate = modifyDate;
        this.modifyUser = modifyUser;
        this.createDate = createDate;
    }

    public void setMap(Map map) {
    }
}
