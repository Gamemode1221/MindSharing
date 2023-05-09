package com.spring.Repository;

import com.spring.entity.Node;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NodeRepository extends JpaRepository<Node, Long> {
    List<Node> findByMapIdAndParentId(Long mapid, Long parentId);

    Node findNodeByMapIdAndNodeId(Long mapId, Long parentId);
}

