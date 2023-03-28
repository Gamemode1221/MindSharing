package com.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Calendars {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long CalendarId;

    private Long userId;
    private Long nodeId;
    private String nodeDetail;
    private Date creationDate;
    private Long mapId;
    private String mapName;

    public Calendars() {
    }

    public Calendars(Long userId, Long nodeId, String nodeDetail, Date creationDate, Long mapId, String mapName) {
        this.userId = userId;
        this.nodeId = nodeId;
        this.nodeDetail = nodeDetail;
        this.creationDate = creationDate;
        this.mapId = mapId;
        this.mapName = mapName;
    }
}
