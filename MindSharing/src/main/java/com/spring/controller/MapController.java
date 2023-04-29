package com.spring.controller;

import com.spring.Repository.MapRepository;
import com.spring.Service.MapService;
import com.spring.entity.dto.MapRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
public class MapController {

    private MapService mapService;

    private MapRepository mapRepository;

    @PostMapping("/mindmaplist")
    public ResponseEntity<Boolean> map(@RequestBody MapRequest request) throws Exception {
        return new ResponseEntity<>(mapService.map(request), HttpStatus.OK);
    }

    public ResponseEntity<String> addMap(@RequestBody Map<String, String> payload) {

        String mapName = payload.get("mapName");
        mapService.map(mapName);

        return ResponseEntity.ok("마인드맵 생성 완료");
    }

    @GetMapping("/map/list")
    @ResponseBody
    public List<com.spring.entity.Map> getMap() {

        List<com.spring.entity.Map> map = mapService.getMap();

        if (map == null) return null;

        return mapService.getMap();
    }


//    @GetMapping("/mapform")
//    public String map(MapCreateForm mapCreateForm, Model model) {
//        model.addAttribute("mapCreateForm", mapCreateForm);
//        return "map_form";
//    }
//
//    @PostMapping("/mapform")
//    @ResponseBody
//    public String creatrmap(@RequestParam String mapName, @ModelAttribute MapCreateForm mapCreateForm, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "map_form";
//        }
//        mapService.create(mapName);
//        return mapName;
//    }

//    @Getter
//    @Setter
//    public static class MapRequest {
//        private String mapName;
//    }


//    @GetMapping("/mapView.html")
//    public String mapView(Model model) {
//        List<Map> maps = mapRepository.findAll();
//        model.addAttribute("maps", maps);
//        return "mapView";
//    }
//
//    @GetMapping("/MapDetail/{mapId}")
//    public String getMapDetail(@PathVariable Long mapId, Model model, Long mapid) {
//        Map map = mapRepository.findById(mapId).orElseThrow();
//        model.addAttribute("map", map);
//
//        return "mapDetail";
//    }


}
