package com.spring.controller;

import com.spring.Form.TeamCreateForm;
import com.spring.Repository.TeamRepository;
import com.spring.Service.TeamService;
import com.spring.entity.Team;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    private final TeamRepository teamRepository;


//    @PostMapping("/team")
//    public ResponseEntity<Boolean> team(@RequestBody TeamRequest request) throws Exception {
//        return new ResponseEntity<>(teamService.team(request), HttpStatus.OK);
//    }


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
