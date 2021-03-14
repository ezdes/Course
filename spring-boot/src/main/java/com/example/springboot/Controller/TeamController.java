package com.example.springboot.Controller;

import com.example.springboot.Entity.Team;
import com.example.springboot.Service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamController {
    private final TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @GetMapping("/team")
    public List<Team> findAll() {
       return teamService.findAll();
    }

    @GetMapping("/team/{teamId}")
    public Team findById(@PathVariable Long teamId) {
        return teamService.findById(teamId);
    }

    @PostMapping("/team")
    public Team addTeam(@RequestBody Team team) {
        return teamService.create(team);
    }

    @PutMapping("/team/{teamId}")
    public Team updateTeam(@RequestBody Team newTeam, @PathVariable Long teamId) {
        return teamService.updateById(newTeam, teamId);
    }

    @DeleteMapping("/team/{teamId}")
    public void deleteTeam(@PathVariable Long teamId) {
        teamService.deleteById(teamId);
    }
}
