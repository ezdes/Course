package com.example.springboot.Service;

import com.example.springboot.Entity.Team;
import com.example.springboot.Exceptions.ResourceNotFoundException;
import com.example.springboot.Repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TeamService {

    private final TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team create(Team team) {
        return teamRepository.save(team);
    }

    public void deleteById(Long id) {
        teamRepository.deleteById(id);
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Team findById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Team updateById(Team newTeam, Long id) {
        return teamRepository.findById(id)
                .map(team -> {
                   team.setName(newTeam.getName());
                   team.setTeamLeadId(newTeam.getTeamLeadId());
                   return teamRepository.save(team);
                })
                .orElseThrow(ResourceNotFoundException::new);
    }
}
