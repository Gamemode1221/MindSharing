package com.spring.Repository;

import com.spring.entity.Nodes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NodeRepository extends JpaRepository<Nodes, Long> {
}
