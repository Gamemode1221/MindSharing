package com.spring.Service;

import com.spring.Repository.NodeRepository;
import com.spring.entity.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NodeService {

    private List<Node> node = new ArrayList<>();
    @Autowired
    private final NodeRepository nodeRepository;

    public NodeService(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }
    public Node create(String detail){
        Node node = new Node();
        node.setDetail(detail);
        this.nodeRepository.save(node);
        return node;
    }
    public List<Node> getNode() {
        return node;
    }

}
