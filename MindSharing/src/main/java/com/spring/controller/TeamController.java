package com.spring.controller;

import com.spring.Repository.TeamRepository;
import com.spring.Service.TeamService;
import com.spring.entity.dto.TeamRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

        String teamname = payload.get("teamname");
        teamService.team(teamname);

        return ResponseEntity.ok("팀 생성 완료");
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
