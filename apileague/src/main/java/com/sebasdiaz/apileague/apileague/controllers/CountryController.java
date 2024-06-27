package com.sebasdiaz.apileague.apileague.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.sebasdiaz.apileague.apileague.entities.Country;
import com.sebasdiaz.apileague.apileague.repositories.CountryRepository;

@RestController
@RequestMapping("/country")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public List<Country> getAllCountrys() {
        return countryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable Long id) {
        return countryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No countries were found with that ID: " + id));
    }

    @PostMapping
    public Country createdCountry(@RequestBody Country country){
        return countryRepository.save(country);
    }

    @PutMapping("/{id}")
    public Country updateCountry(@PathVariable Long id, @RequestBody Country countryDetails){
        Country country = countryRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("No countries were found with that ID: " + id));
        
        country.setName(countryDetails.getName());
        country.setContient(countryDetails.getContient());
    
        return countryRepository.save(country);
    }

    @DeleteMapping("/{id}")
    public String deletedCountry(@PathVariable Long id){
        Country country = countryRepository.findById(id)
                .orElseThrow( () -> new RuntimeException("No countries were found with that ID: " + id));
        
        countryRepository.delete(country);

        return "The Country has been successfully eliminated";
    } 
}
