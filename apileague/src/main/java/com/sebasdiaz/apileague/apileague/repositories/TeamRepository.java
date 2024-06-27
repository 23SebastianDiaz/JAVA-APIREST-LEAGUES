package com.sebasdiaz.apileague.apileague.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sebasdiaz.apileague.apileague.entities.Team;

public interface TeamRepository extends JpaRepository<Team,Long>{
    
}
