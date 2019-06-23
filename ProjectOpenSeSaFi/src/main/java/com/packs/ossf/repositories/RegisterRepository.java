package com.packs.ossf.repositories;

import com.packs.ossf.models.RegisterUserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RegisterRepository extends JpaRepository<RegisterUserModel,Long> {
    Optional<RegisterUserModel> findByUserid(String username);
}

