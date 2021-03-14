package com.example.springboot.Controller;

import com.example.springboot.Entity.TeamLead;
import com.example.springboot.Service.TeamLeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TeamLeadController {
    private final TeamLeadService teamLeadService;

    @Autowired
    public TeamLeadController(TeamLeadService teamLeadService) {
        this.teamLeadService = teamLeadService;
    }

    @GetMapping("/teamLead")
    public List<TeamLead> findAll() {
        return teamLeadService.findAll();
    }

    @GetMapping("/teamLead/{teamLeadId}")
    public TeamLead findById(@PathVariable Long teamLeadId) {
        return teamLeadService.findById(teamLeadId);
    }

    @PostMapping("/teamLead")
    public TeamLead addTeam(@RequestBody TeamLead teamLead) {
        return teamLeadService.create(teamLead);
    }

    @PutMapping("/teamLead/{teamLeadId}")
    public TeamLead updateTeam(@RequestBody TeamLead newTeamLead, @PathVariable Long teamLeadId) {
        return teamLeadService.updateById(newTeamLead, teamLeadId);
    }

    @DeleteMapping("/teamLead/{teamLeadId}")
    public void deleteTeam(@PathVariable Long teamLeadId) {
        teamLeadService.deleteById(teamLeadId);
    }
}
