package com.spring.Service;


import com.spring.Repository.TeamRepository;
import com.spring.entity.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamService {

    private List<Team> team = new ArrayList<>();

    @Autowired
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team create(String teamName) { //, Long ownerId, List<String> memberIds, Long mapId, String notice, List<String> favoriteUsers
        Team team = new Team();
        team.setTeamName(teamName); //팀 이름


//        team.setOwnerId(ownerId); //팀장 userid
//        team.setMemberId(String.join(",", memberIds)); //팀원 userid
//        team.setMapId(mapId); //보유 마인드맵 mapid
//        team.setNotice(notice); // 공지
//        team.setFavoriteUsers(String.join(",", favoriteUsers)); //즐겨찾기를 한 팀원 userid


        this.teamRepository.save(team);
        return team;
    }

    public List<Team> getTeam() {
        return this.teamRepository.findAll();
    }
}


