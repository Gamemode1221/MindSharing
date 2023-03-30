package com.spring.Repository;

import com.spring.entity.Teams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Teams, Long> {
}
