package com.projectrest.starwarsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectrest.starwarsapi.entity.Planet;

public interface PlanetRepository extends JpaRepository<Planet, Long>{

}
