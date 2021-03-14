package com.example.springboot.Repository;

import com.example.springboot.Entity.TeamLead;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamLeadRepository extends JpaRepository<TeamLead, Long> {
}
