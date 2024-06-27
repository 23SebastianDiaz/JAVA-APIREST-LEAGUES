package com.sebasdiaz.apileague.apileague.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sebasdiaz.apileague.apileague.entities.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{


}
