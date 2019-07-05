package com.packs.flyy.repositories;

import com.packs.flyy.models.entity.Admin.AdminProfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminProfileRepository extends JpaRepository<AdminProfiles,Long> {
    Optional<AdminProfiles> findByUsername(String username);
    Optional<AdminProfiles> findByUserid(Long userid);
    Boolean existsByUsername(String username);
}
