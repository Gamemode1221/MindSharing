package com.spring.controller;

import com.spring.Form.NodeCreateForm;
import com.spring.Repository.MapRepository;
import com.spring.Repository.NodeRepository;
import com.spring.Service.NodeService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
public class NodeController {

    @Autowired
    private NodeService nodeService;

    @Autowired
    private MapRepository mapRepository;

    @Autowired
    private NodeRepository nodeRepository;

    @GetMapping("/NodeDetail/{mapid}/")
    public String node(@PathVariable Long mapid, NodeCreateForm nodeCreateForm, Model model) {
        model.addAttribute("nodeCreateForm", nodeCreateForm);
        return "mapDetail";
    }
    @PostMapping("/NodeDetail/{mapid}/")
    @ResponseBody
    public String creatrnode(@RequestParam String detail, @ModelAttribute NodeCreateForm nodeCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "mapDetail";
        }
        nodeService.create(detail);
        return detail;
    }

    @Getter
    @Setter
    public static class NodeRequest {
        private String detaile;
    }
}


