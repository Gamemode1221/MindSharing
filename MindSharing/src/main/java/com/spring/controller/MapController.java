package com.spring.controller;

import com.spring.Form.MapCreateForm;
import com.spring.Service.MapService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MapController {

    @Autowired
    private MapService mapService;

    @GetMapping("/map")
    public String map(MapCreateForm mapCreateForm, Model model) {
        model.addAttribute("mapCreateForm", mapCreateForm);
        return "map_form";

//    @PostMapping("/map")
//    public ResponseEntity<Void> saveMap(@RequestBody MapRequest mapRequest) {
//        mapService.saveMap(mapRequest.getTeamId(), mapRequest.getMapName(), mapRequest.getUpdateHistory());
//        return new ResponseEntity<>(HttpStatus.CREATED);
//
//    }
    }

    @Getter
    @Setter
    public static class MapRequest {

        private Long teamId;
        private String mapName;
        private Boolean updateHistory;

    }
}
