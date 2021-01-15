package com.projectrest.starwarsapi.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.projectrest.starwarsapi.dto.request.PlanetDTO;
import com.projectrest.starwarsapi.entity.Planet;
import com.projectrest.starwarsapi.utils.PlanetUtils;

@ExtendWith(MockitoExtension.class)
public class PlanetMapperTest {

	private final PlanetMapper planetMapper = PlanetMapper.INSTANCE;

	@Test
	void testGivenPersonDTOThenReturnPersonEntity() {

		PlanetDTO planetDTO = PlanetUtils.createFakeDTO();
		Planet planet = planetMapper.toModel(planetDTO);

		assertEquals(planetDTO.getName(), planet.getName());
		assertEquals(planetDTO.getClimate(), planet.getClimate());
		assertEquals(planetDTO.getTerrain(), planet.getTerrain());

	}

	@Test
	void testGivenPersonEntityThenReturnPersonDTO() {
		Planet planet = PlanetUtils.createFakeEntity();
		PlanetDTO planetDTO = planetMapper.toDTO(planet);

		assertEquals(planet.getName(), planetDTO.getName());
		assertEquals(planet.getClimate(), planetDTO.getClimate());
		assertEquals(planet.getTerrain(), planetDTO.getTerrain());

	}
}
