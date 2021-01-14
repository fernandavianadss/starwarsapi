package com.projectrest.starwarsapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectrest.starwarsapi.dto.request.PlanetDTO;
import com.projectrest.starwarsapi.dto.response.MessageResponseDTO;
import com.projectrest.starwarsapi.entity.Planet;
import com.projectrest.starwarsapi.exception.PlanetNotFoundException;
import com.projectrest.starwarsapi.mapper.PlanetMapper;
import com.projectrest.starwarsapi.repository.PlanetRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PlanetService {
	
    private PlanetRepository planetRepository;
    
    private final PlanetMapper planetMapper = PlanetMapper.INSTANCE;
    

	public MessageResponseDTO createPlanet(PlanetDTO planetDTO) {
		
		Planet planetToSave = planetMapper.toModel(planetDTO);
				
		Planet planetSave = planetRepository.save(planetToSave);
		
		return createMessageResponse(planetSave.getId(), "Created planet with id ");
		
	}

	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
                .builder()
                .message(message + id)
                .build();
	}

	public List<Planet> listAll() {
		return planetRepository.findAll();
	}

	public Planet findById(Long id) throws PlanetNotFoundException {
		Planet planet = verifyIfExists(id);

        return planet;
	}

	public Planet findByName(String name) {
		Planet planet = verifyIfExistsByName(name);

        return planet;
	}
	
	private Planet verifyIfExists(Long id) throws PlanetNotFoundException {
	        return planetRepository.findById(id)
	                .orElseThrow(() -> new PlanetNotFoundException(id));
	}
	
	private Planet verifyIfExistsByName(String name) throws PlanetNotFoundException {
        return planetRepository.findByName(name)
                .orElseThrow(() -> new PlanetNotFoundException(name));
}

}
