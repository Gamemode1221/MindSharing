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

        if (parentId != null) { //parentId가 null인지 확인
            Optional<Node> parentNodeOptional = nodeRepository.findById(parentId);
            if (parentNodeOptional.isPresent()) {  //parentId가 null이 아닌 경우에는 parentId가 유효한지 검증
                Node parentNode = parentNodeOptional.get();
                if (parentNode.getMapId().equals(mapid)) { //parentId가 유효하면 노드에 parentId를 설정한 후 저장
                    node.setParentId(parentId);
                } else { //parentId로 조회한 노드가 존재하지 않으면 예외처리
                    throw new IllegalArgumentException("parentId does not belong to the same map");
                }
            } else {
                throw new IllegalArgumentException("invalid parentId");
            }
        }

        this.nodeRepository.save(node); // null이면 그냥 저장
        return node;
    }
    public List<Node> getNode() {
        return node;
    }

}

