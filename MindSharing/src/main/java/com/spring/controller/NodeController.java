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

//    @GetMapping("/MapDetail/{mapid}/")
//    public String node(@PathVariable Long mapid, NodeCreateForm nodeCreateForm, Model model) {
//        model.addAttribute("nodeCreateForm", nodeCreateForm);
//        return "nodeDetail";
//    }
//    @PostMapping("/MapDetail/{mapid}/")
//    @ResponseBody
//    public String creatrnode(@RequestParam String detail, @ModelAttribute NodeCreateForm nodeCreateForm, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "mapDetail";
//        }
//        nodeService.create(detail);
//        return detail;
//    }
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

//    @GetMapping("/MapDetail/{mapId}/{detail}")
//    public String getNodeDetail( @PathVariable Long detail, Model model) {
////        Map map = mapRepository.findById(mapId).orElseThrow();
//        Node node = nodeRepository.findById(detail).orElseThrow();
//        model.addAttribute("node", node);
//        return "nodeDetail";
//    }

    @PostMapping("/MapDetail/{mapid}")
    public String createNode(@PathVariable Long mapid, @RequestParam String detail, Long mapId, Long parentId, Model model) {
        nodeService.create(mapid, detail, mapId, parentId);
        Map map = mapRepository.findById(mapId).orElseThrow();
        model.addAttribute("map", map);
        return "redirect:/MapDetail/" + mapid + "/nodeList";
    }

    @GetMapping("/MapDetail/{mapid}/nodeList")
    public String nodeView(@PathVariable Long mapid, Model model, Long mapId) {
        List<Node> nodes = nodeRepository.findAll();
        model.addAttribute("mapId", mapId);
        model.addAttribute("nodes", nodes);
        return "nodeList";
    }

}


