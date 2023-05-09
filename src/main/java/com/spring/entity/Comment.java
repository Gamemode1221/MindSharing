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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentsId;

    private Long nodeId;
    private Date modifyDate;
    private Long userId;
    private String detail;

    public Comment() {
    }

    public Comment(Long nodeId, Date modifyDate, Long userId, String detail) {
        this.nodeId = nodeId;
        this.modifyDate = modifyDate;
        this.userId = userId;
        this.detail = detail;
    }
}
