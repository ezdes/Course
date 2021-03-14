package com.example.springboot.Service;

import com.example.springboot.Entity.TeamLead;
import com.example.springboot.Exceptions.ResourceNotFoundException;
import com.example.springboot.Repository.TeamLeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamLeadService {
    private final TeamLeadRepository teamLeadRepository;

    @Autowired
    public TeamLeadService(TeamLeadRepository teamLeadRepository) {
        this.teamLeadRepository = teamLeadRepository;
    }

    public TeamLead create(TeamLead team) {
        return teamLeadRepository.save(team);
    }

    public void deleteById(Long id) {
        teamLeadRepository.deleteById(id);
    }

    public List<TeamLead> findAll() {
        return teamLeadRepository.findAll();
    }

    public TeamLead findById(Long id) {
        return teamLeadRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public TeamLead updateById(TeamLead newTeamLead, Long id) {
        return teamLeadRepository.findById(id)
                .map(teamLead -> {
                    teamLead.setStudentId(newTeamLead.getStudentId());
                    return teamLeadRepository.save(teamLead);
                })
                .orElseThrow(ResourceNotFoundException::new);
    }
}
