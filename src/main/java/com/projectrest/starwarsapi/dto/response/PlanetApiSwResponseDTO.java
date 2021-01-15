package com.projectrest.starwarsapi.dto.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.projectrest.starwarsapi.entity.PlanetApiSw;

import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetApiSwResponseDTO {

	PlanetApiSw[] results;

}
