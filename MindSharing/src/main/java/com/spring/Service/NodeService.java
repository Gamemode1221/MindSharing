package com.spring.Service;

import com.spring.Repository.NodeRepository;
import com.spring.entity.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodeService {

    @Autowired
    private NodeRepository nodeRepository;

    public Node saveNode(Long mapId, String detail) { //Long parentId
        Node node = new Node();
        node.setMapId(mapId);
//        node.setParentId(parentId);
        node.setDetail(detail);
        return nodeRepository.save(node);
    }

    public Node getNodeById(Long nodeId) {
        return nodeRepository.findById(nodeId).orElse(null);
    }
}

