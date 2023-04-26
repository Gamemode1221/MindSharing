package com.spring.entity.dto;

import com.spring.entity.Team;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TeamResponse {


    private String teamname;

    public TeamResponse(Team team) {
        this.teamname = team.getTeamName();
    }
}
