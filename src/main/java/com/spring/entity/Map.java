package com.spring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "map")
@Getter @Setter @Builder @AllArgsConstructor
public class Map {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mapId;

    private String mapName;
    private Boolean updateHistory;
    private Long teamId;

    public Map() {
    }

    public Map(Long teamId, String mapName, Boolean updateHistory) {
        this.mapName = mapName;
        this.teamId = teamId;
        this.updateHistory = updateHistory;
    }
}
