package com.projectrest.starwarsapi.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.projectrest.starwarsapi.dto.request.PlanetDTO;
import com.projectrest.starwarsapi.entity.Planet;

@Mapper
public interface PlanetMapper {
	
	PlanetMapper INSTANCE = Mappers.getMapper(PlanetMapper.class);
	
	Planet toModel(PlanetDTO planetDTO);

	PlanetDTO toDTO(Planet planet);
}
