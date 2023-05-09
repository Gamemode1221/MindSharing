package com.spring.Repository;

import com.spring.entity.Map;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MapRepository extends JpaRepository<Map, Long> {
    Optional<Map> findByMapName(String mapName);
}
