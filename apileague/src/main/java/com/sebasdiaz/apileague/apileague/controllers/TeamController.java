package com.sebasdiaz.apileague.apileague.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.sebasdiaz.apileague.apileague.entities.Team;
import com.sebasdiaz.apileague.apileague.repositories.TeamRepository;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Autowired // Repository instance
    private TeamRepository teamRepository; 

    @GetMapping // Get All Teams
    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/{id}") // Get teams by id 
    public Team getTeamById(@PathVariable Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No teams found with the ID: " + id));
    }

    @PostMapping // Add Object
    public Team createdTeam(@RequestBody Team team){
        return teamRepository.save(team);
    } 

    @PutMapping("/{id}") // Update Object
    public Team updateTeam(@PathVariable Long id, @RequestBody Team teamsDetails){

        Team team = teamRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("No teams found with the ID: " + id));

        team.setName(teamsDetails.getName());
        team.setPresident(teamsDetails.getPresident());

        return teamRepository.save(team);

    }

    @DeleteMapping("/{id}") // Delete Object
    public String deleteTeam(@PathVariable Long id){
        Team team = teamRepository.findById(id)
            .orElseThrow( () -> new RuntimeException("No teams found with the ID: " + id));
        
        teamRepository.delete(team);
        return "The Team has been successfully eliminated";
    }

}
