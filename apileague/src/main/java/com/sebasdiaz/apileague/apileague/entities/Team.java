package com.sebasdiaz.apileague.apileague.entities;

import java.util.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;

    private String name;
    private String president;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "league_id")
    @JsonBackReference
    private League league;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL, orphanRemoval =  true)
    private List<Player> players = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }


}
