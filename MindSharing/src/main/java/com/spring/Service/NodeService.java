package com.spring.Service;

import com.spring.Repository.NodeRepository;
import com.spring.entity.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NodeService {

    private List<Node> node = new ArrayList<>();
    @Autowired
    private final NodeRepository nodeRepository;

    public NodeService(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }
    public Node create(Long mapid, String detail, Long parentId ) {
        Node node = new Node();
        node.setDetail(detail);
        node.setMapId(mapid);

        if (parentId != null) {
            Optional<Node> parentNodeOptional = nodeRepository.findById(parentId);
            if (parentNodeOptional.isPresent()) {
                Node parentNode = parentNodeOptional.get();
                if (parentNode.getMapId().equals(mapid)) {
                    node.setParentId(parentId);
                } else {
                    throw new IllegalArgumentException("parentId does not belong to the same map");
                }
            } else {
                throw new IllegalArgumentException("invalid parentId");
            }
        }

        this.nodeRepository.save(node);
        return node;
    }






    public List<Node> getNode() {
        return node;
    }

}

