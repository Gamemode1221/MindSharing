package com.spring.controller;

import com.spring.Form.TeamCreateForm;
import com.spring.Repository.TeamRepository;
import com.spring.Service.TeamService;
import com.spring.entity.Team;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    private TeamRepository teamRepository;

    @GetMapping("/teamform")
    public String team(TeamCreateForm teamCreateForm, Model model) {
        model.addAttribute("teamCreateForm", teamCreateForm);
        return "team_form";
    }

    @PostMapping("/teamform")
    @ResponseBody
    public String createTeam(@RequestParam String teamName, @ModelAttribute TeamCreateForm teamCreateForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "team_form";
        }
        teamService.create(teamName);
        return teamName;
    }

    @Getter
    @Setter
    public static class TeamRequest {
        private String teamName;
    }


    @GetMapping("/team_View.html")
    public String teamView(Model model) {
        List<Team> teams = teamRepository.findAll();
        model.addAttribute("teams", teams);
        return "team_View";
    }
}
