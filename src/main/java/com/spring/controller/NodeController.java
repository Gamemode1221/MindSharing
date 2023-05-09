package com.spring.controller;

import com.spring.Repository.MapRepository;
import com.spring.Repository.NodeRepository;
import com.spring.Service.NodeService;
import com.spring.entity.Map;
import com.spring.entity.Node;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @Autowired
    private MapRepository mapRepository;

    @Autowired
    private NodeRepository nodeRepository;

    @GetMapping("/NodeCreateForm")
    public String getNodeCreateForm(Model model) {
        model.addAttribute("nodeCreateForm", new Node());
        return "nodeCreateForm";
    }

    @PostMapping("/NodeCreateForm")
    public String postNodeCreateForm(@ModelAttribute Node nodeCreateForm) {
        nodeRepository.save(nodeCreateForm);
        return "redirect:/MapDetail";
    }

    @PostMapping("/MapDetail/{mapid}")
    public String createNode(@PathVariable Long mapid, @RequestParam String detail, Long mapId, Long parentId, Model model, Date createDate) {
        nodeService.create(mapid, detail, parentId, createDate);
        Map map = mapRepository.findById(mapid).orElseThrow();
        model.addAttribute("map", map);

        return "redirect:/MapDetail/" + mapid;
    }

    @GetMapping("/MapDetail/{mapid}/nodeList")
    public String nodeView(@PathVariable Long mapid, Model model, Long mapId) {
        List<Node> nodes = nodeRepository.findAll();
        model.addAttribute("mapId", mapId);
        model.addAttribute("nodes", nodes);
        Map map = mapRepository.findById(mapid).orElseThrow();
        model.addAttribute("map", map);
        return "nodeList";
    }

}


