package com.spring.Service;


import com.spring.Repository.TeamRepository;
import com.spring.entity.Team;
import com.spring.entity.dto.TeamRequest;
import org.springframework.stereotype.Service;

import java.util.List;

//@RequiredArgsConstructor
@Service
public class TeamService {

    public List<Team> getTeam() {
        return teamRepository.findAll();
    }

    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public boolean team(TeamRequest request) throws Exception {
        try {
            Team team = Team.builder()
                    .teamName(request.getTeamName())
                    .build();

            teamRepository.save(team);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new Exception("잘못된 요청입니다.");
        }
        return true;
    }

    public void team(String teamName) {
        Team team = new Team();

        team.setTeamName(teamName);
        teamRepository.save(team);
    }

//    public Team create(String teamName) { //, Long ownerId, List<String> memberIds, Long mapId, String notice, List<String> favoriteUsers
//        Team team = new Team();
//        team.setTeamName(teamName); //팀 이름
////        team.setOwnerId(ownerId); //팀장 userid
////        team.setMemberId(String.join(",", memberIds)); //팀원 userid
////        team.setMapId(mapId); //보유 마인드맵 mapid
////        team.setNotice(notice); // 공지
////        team.setFavoriteUsers(String.join(",", favoriteUsers)); //즐겨찾기를 한 팀원 userid
//
//
//        this.teamRepository.save(team);
//        return team;
//    }

}


