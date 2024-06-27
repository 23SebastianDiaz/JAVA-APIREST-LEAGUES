package com.sebasdiaz.apileague.apileague.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sebasdiaz.apileague.apileague.entities.Player;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    
}
