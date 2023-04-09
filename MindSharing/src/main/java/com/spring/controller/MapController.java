package com.spring.controller;

import com.spring.Form.MapCreateForm;
import com.spring.Repository.MapRepository;
import com.spring.Service.MapService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class MapController {

    @Autowired
    private MapService mapService;

    @Autowired
    private MapRepository mapRepository;

    @GetMapping("/mapform")
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

//        private Long teamId;
        private String mapName;
//        private Boolean updateHistory;

    }
}
