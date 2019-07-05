package com.packs.flyy.repositories;

import com.packs.flyy.models.entity.Agent.AgentProfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentProfileRepository extends JpaRepository<AgentProfiles,Long> {
    Optional<AgentProfiles> findByUsername(String username);
    Boolean existsByUsername (String username);
}
