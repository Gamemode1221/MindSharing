package com.spring.controller;

import com.spring.Form.NodeCreateForm;
import com.spring.Service.NodeService;
import com.spring.entity.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/nodes")
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @GetMapping("/{nodeId}")
    public String getNode(@PathVariable Long nodeId, Model model) {
        Node node = nodeService.getNodeById(nodeId);
        model.addAttribute("node", node);
        return "nodeDetail";
    }

    @PostMapping("/create")
    public String createNode(@ModelAttribute NodeCreateForm nodeCreateForm, Model model) {
        Long mapId = nodeCreateForm.getMapId();
        //Long parentId = nodeCreateForm.getParentId();
        String detail = nodeCreateForm.getDetail();

        nodeService.saveNode(mapId, detail); //parentId
        return "redirect:/maps/" + mapId;
    }
}

