package com.projectrest.starwarsapi.controller;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projectrest.starwarsapi.dto.request.PlanetDTO;
import com.projectrest.starwarsapi.dto.response.MessageResponseDTO;
import com.projectrest.starwarsapi.entity.Planet;
import com.projectrest.starwarsapi.exception.PlanetNotFoundException;
import com.projectrest.starwarsapi.service.PlanetService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/planets")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PlanetController {
	
	private PlanetService planetService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPlanet(@RequestBody PlanetDTO planetDTO) throws PlanetNotFoundException, URISyntaxException {
		return planetService.createPlanet(planetDTO);
	}
	
	@GetMapping
	public List<Planet> listAll() {
		return planetService.listAll();
	}
	
	@GetMapping("name/{name}")
	public Planet findByName(@PathVariable("name") String name) throws PlanetNotFoundException{	
		return planetService.findByName(name);
	}
	
	@GetMapping("/{id}")
    public Planet findById(@PathVariable Long id) throws PlanetNotFoundException {
        return planetService.findById(id);
    }
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteById(@PathVariable Long id) throws PlanetNotFoundException {
		planetService.deleteById(id);
	}
	
	
	
}
