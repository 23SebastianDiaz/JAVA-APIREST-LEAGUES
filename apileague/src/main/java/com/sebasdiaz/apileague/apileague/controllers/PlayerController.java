package com.sebasdiaz.apileague.apileague.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sebasdiaz.apileague.apileague.entities.Player;
import com.sebasdiaz.apileague.apileague.repositories.PlayerRepository;

import java.util.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    @Autowired // Repository instance
    private PlayerRepository playerRepository;

    @GetMapping // Get all objects
    public List<Player> getAllPlayer() {
        return playerRepository.findAll();
    }

    @GetMapping("/{id}") // Get objects by id
    public Player getPlayerById(@PathVariable Long id) {
        return playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No players were found with the ID: " + id));
    }

    @PostMapping // Add object
    public Player createdPlayer(@RequestBody Player player){
        return playerRepository.save(player);
    }

    @PutMapping("/{id}") // Update object
    public Player updatePlayer (@PathVariable Long id, @RequestBody Player playerDetails){
        Player player = playerRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("No players were found with the ID: " + id));
        
        player.setName(playerDetails.getName());
        player.setAge(playerDetails.getAge());
        player.setPosition(playerDetails.getPosition());
        player.setNumber(playerDetails.getNumber());
        player.setTeam(playerDetails.getTeam());
        player.setCountry(playerDetails.getCountry());

        return playerRepository.save(player);
    }

    @DeleteMapping("/{id}")
    public String deletePlayer(@PathVariable Long id){
        Player player = playerRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("No players were found with the ID: " + id));

        playerRepository.delete(player);

        return "The Player has been successfully eliminated";
    }



}
