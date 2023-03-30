package com.spring.Repository;

import com.spring.entity.Maps;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MapRepository extends JpaRepository<Maps, Long> {
}
