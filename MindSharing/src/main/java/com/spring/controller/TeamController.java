package com.spring.controller;

import com.spring.Repository.TeamRepository;
import com.spring.Service.TeamService;
import com.spring.entity.Team;
import com.spring.entity.dto.TeamRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    private final TeamRepository teamRepository;


    @PostMapping("/team")
    public ResponseEntity<Boolean> team(@RequestBody TeamRequest request) throws Exception {
        return new ResponseEntity<>(teamService.team(request), HttpStatus.OK);
    }

    public ResponseEntity<String> addTeam(@RequestBody Map<String, String> payload) {

        String teamName = payload.get("teamName");
        teamService.team(teamName);

        return ResponseEntity.ok("팀 생성 완료");
    }

    @GetMapping("/team/list")
    @ResponseBody
    public List<Team> getTeam() {

        List<Team> team = teamService.getTeam();

        if (team == null) return null;

        return teamService.getTeam();
    }


//    @GetMapping("/teamform")
//    public String team(TeamCreateForm teamCreateForm, Model model) {
//        model.addAttribute("teamCreateForm", teamCreateForm);
//        return "team_form";
//    }
//    @PostMapping("/teamform")
//    @ResponseBody
//    public String createTeam(@RequestParam String teamName, @ModelAttribute TeamCreateForm teamCreateForm, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return "team_form";
//        }
//        teamService.create(teamName);
//        return teamName;
//    }
//    @GetMapping("/team_View.html")
//    public String teamView(Model model) {
//        List<Team> teams = teamRepository.findAll();
//        model.addAttribute("teams", teams);
//        return "team_View";
//    }
}
