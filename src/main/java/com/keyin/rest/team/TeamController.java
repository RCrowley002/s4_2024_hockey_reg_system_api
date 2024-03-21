package com.keyin.rest.team;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping("/team")
    public List<Team> getAllTeams() {
        return teamService.getAllTeams();
    }

    @GetMapping("/team/{id}")
    public Team getTeamById(@PathVariable long id) {
        return teamService.getTeamById(id);
    }

    @PostMapping("/team")
    public Team createTeam(@RequestBody Team team) {
        System.out.println(team.getDivision());

        return teamService.createTeam(team);
    }

    @PutMapping("/team/{id}")
    public ResponseEntity<Team> updateTeam(@PathVariable long id, @RequestBody Team team) {
        return ResponseEntity.ok(teamService.updateTeam(id, team));
    }

    @DeleteMapping("/team/{id}")
    public void deleteTeamById(@PathVariable long id) {
        teamService.deleteTeamById(id);
    }
}
