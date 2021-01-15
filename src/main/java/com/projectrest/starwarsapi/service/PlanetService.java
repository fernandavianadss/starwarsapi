package com.projectrest.starwarsapi.service;

import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projectrest.starwarsapi.dto.request.PlanetDTO;
import com.projectrest.starwarsapi.dto.response.MessageResponseDTO;
import com.projectrest.starwarsapi.entity.Planet;
import com.projectrest.starwarsapi.entity.PlanetApiSw;
import com.projectrest.starwarsapi.exception.PlanetNotFoundException;
import com.projectrest.starwarsapi.mapper.PlanetMapper;
import com.projectrest.starwarsapi.repository.PlanetRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PlanetService {

	private PlanetRepository planetRepository;

	private PlanetApiSwService planetApiSwService;

	private final PlanetMapper planetMapper = PlanetMapper.INSTANCE;
	

	public MessageResponseDTO createPlanet(PlanetDTO planetDTO) throws PlanetNotFoundException, URISyntaxException {

		Planet planetToSave = planetMapper.toModel(planetDTO);

		planetToSave.setAppearance(appearancePlanetFilms(planetToSave.getName()));

		Planet planetSave = planetRepository.save(planetToSave);

		return createMessageResponse(planetSave.getId(), "Created planet with id ");

	}

	public Integer appearancePlanetFilms(String name) throws URISyntaxException, PlanetNotFoundException {

		return verifyIfExistsPlanetApiSw(name).stream().filter(p -> p.getName().equalsIgnoreCase(name)).map(p -> {
			if (p.getFilms() == null)
				return 0;
			return p.getFilms().length;
		}).mapToInt(Integer::intValue).sum();
	}

	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO.builder().message(message + id).build();
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

	public void deleteById(Long id) throws PlanetNotFoundException {

		verifyIfExists(id);

		planetRepository.deleteById(id);
	}

	private Planet verifyIfExists(Long id) throws PlanetNotFoundException {
		return planetRepository.findById(id).orElseThrow(() -> new PlanetNotFoundException(id));
	}

	private Planet verifyIfExistsByName(String name) throws PlanetNotFoundException {
		return planetRepository.findByName(name).orElseThrow(() -> new PlanetNotFoundException(name));
	}

	private List<PlanetApiSw> verifyIfExistsPlanetApiSw(String name)
			throws URISyntaxException, PlanetNotFoundException {

		List<PlanetApiSw> planetApiSw = planetApiSwService.getSWAPIPlanet(name);
		if (planetApiSw == null || planetApiSw.isEmpty()) {
			new PlanetNotFoundException(name);
		}

		return planetApiSw;
	}

}
