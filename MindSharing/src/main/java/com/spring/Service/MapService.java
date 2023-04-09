package com.spring.Service;

import com.spring.Repository.MapRepository;
import com.spring.entity.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MapService {

    private List<Map> map = new ArrayList<>();
    @Autowired
    private final MapRepository mapRepository;

    public MapService(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

//    public void saveMap(Long teamId, String mapName, Boolean updateHistory) {
//        Map map = new Map(teamId, mapName, updateHistory);
//        mapRepository.save(map);
//    }
    public Map create(String mapName){ //Long teamId, Boolean updateHistory
        Map map = new Map();
        map.setMapName(mapName);
//        map.setTeamId(teamId);
//        map.setUpdateHistory(updateHistory);
        this.mapRepository.save(map);
        return map;
    }
    public List<Map> getMap() {
        return map;
    }

}
