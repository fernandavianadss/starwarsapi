package com.projectrest.starwarsapi.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.projectrest.starwarsapi.entity.Planet;

@Repository
public interface PlanetRepository extends JpaRepository<Planet, Long>{
	
	@Query("SELECT p FROM Planet p WHERE p.name= :name")
	Optional<Planet> findByName(@Param("name") String name);
}
