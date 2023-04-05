package com.spring.Service;

import com.spring.Repository.MapRepository;
import com.spring.entity.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MapService {

    @Autowired
    private final MapRepository mapRepository;

    public MapService(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

//    public void saveMap(Long teamId, String mapName, Boolean updateHistory) {
//        Map map = new Map(teamId, mapName, updateHistory);
//        mapRepository.save(map);
//    }
    public Map create(Long teamId, String mapName, Boolean updateHistory){
        Map map = new Map();
        map.setMapName(mapName);
        this.mapRepository.save(map);
        return map;
    }
}
