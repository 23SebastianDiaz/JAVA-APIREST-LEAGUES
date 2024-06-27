package com.sebasdiaz.apileague.apileague.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sebasdiaz.apileague.apileague.entities.League;

public interface LeagueRepository extends JpaRepository<League, Long>{
    
}
