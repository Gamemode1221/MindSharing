package com.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Maps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mapId;

    private Long teamId;
    private String mapName;
    private Boolean updateHistory;

    public Maps() {
    }

    public Maps(Long teamId, String mapName, Boolean updateHistory) {
        this.teamId = teamId;
        this.mapName = mapName;
        this.updateHistory = updateHistory;
    }
}
