package com.packs.flyy.repositories;


import com.packs.flyy.models.entity.UsersProfiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersRepository extends JpaRepository<UsersProfiles, Long> {
}
