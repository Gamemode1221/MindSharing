package com.spring.controller;

import com.spring.Service.MapService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapController {

    @Autowired
    private MapService mapService;

    @PostMapping("/map")
    public ResponseEntity<Void> saveMap(@RequestBody MapRequest mapRequest) {
        mapService.saveMap(mapRequest.getTeamId(), mapRequest.getMapName(), mapRequest.getUpdateHistory());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Getter
    @Setter
    public static class MapRequest {

        private Long teamId;
        private String mapName;
        private Boolean updateHistory;

    }
}
