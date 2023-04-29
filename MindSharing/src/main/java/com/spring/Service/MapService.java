package com.spring.Service;

import com.spring.Repository.MapRepository;
import com.spring.entity.Map;
import com.spring.entity.dto.MapRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MapService {

    public List<Map> getMap() {
        return mapRepository.findAll();
    }

    private final MapRepository mapRepository;

    public MapService(MapRepository mapRepository) {
        this.mapRepository = mapRepository;
    }

    public boolean map(MapRequest request) throws Exception {
        try {
            Map map = Map.builder()
                    .mapName(request.getMapName())
                    .build();

            mapRepository.save(map);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("잘못된 요청입니다.");
        }
        return true;
    }

    public void map(String mapName) {
        Map map = new Map();

        map.setMapName(mapName);
        mapRepository.save(map);
    }

    public Map create(String mapName){ //Long teamId, Boolean updateHistory
        Map map = new Map();
        map.setMapName(mapName);
        this.mapRepository.save(map);
        return map;
    }

}
