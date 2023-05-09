package com.spring.entity.dto;

import com.spring.entity.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MapResponse {


    private String mapName;

    public MapResponse(Map map) {
        this.mapName = map.getMapName();
    }
}
