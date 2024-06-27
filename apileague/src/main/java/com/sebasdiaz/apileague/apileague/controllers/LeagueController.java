package com.sebasdiaz.apileague.apileague.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.sebasdiaz.apileague.apileague.entities.League;
import com.sebasdiaz.apileague.apileague.repositories.LeagueRepository;
import java.util.*;

@RestController // Decorador de CRUD
@RequestMapping("/league")
public class LeagueController {

    @Autowired // Repository instance
    private LeagueRepository leagueRepository;

    @GetMapping // Get all objects
    public List<League> getAllLeague() {
        return leagueRepository.findAll();
    }

    @GetMapping("/{id}") // Get objects by ID
    public League getLeagueById(@PathVariable Long id) {
        return leagueRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No leagues found with the ID: "+ id));
    }

    @PostMapping() // Add object
    public League createLeague(@RequestBody League league) {
        return leagueRepository.save(league);
    }

    @PutMapping("/{id}") // Update Object
    public League updatLeague(@PathVariable Long id, @RequestBody League leagueDetails){
        League league = leagueRepository.findById(id)
        .orElseThrow( () -> new RuntimeException("No leagues found with the ID: " + id));

        league.setName(leagueDetails.getName());
        league.setTeams(leagueDetails.getTeams());
        league.setCountry(leagueDetails.getCountry());
        

        return leagueRepository.save(league);
    }

    @DeleteMapping("/{id}") // Delete Object
    public String deleteLeague(@PathVariable Long id){
        League league = leagueRepository.findById(id)
        .orElseThrow( () -> new RuntimeException("No leagues found with the ID: " + id));

        leagueRepository.delete(league);
        return "The league has been successfully eliminated"; 
    }

}
