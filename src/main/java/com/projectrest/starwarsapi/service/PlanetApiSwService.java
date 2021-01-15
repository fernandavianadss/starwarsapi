package com.projectrest.starwarsapi.service;

import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.client.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.projectrest.starwarsapi.dto.response.PlanetApiSwResponseDTO;
import com.projectrest.starwarsapi.entity.PlanetApiSw;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PlanetApiSwService {

	private RestTemplate restTemplate;

	public static final String SWAPI_BASE_URL = "https://swapi.dev";
	public static final String SWAPI_PLANETS_RESOURCE = "/api/planets/";

	public List<PlanetApiSw> getSWAPIPlanet(String nome) throws URISyntaxException {

		URIBuilder searchURL = new URIBuilder(PlanetApiSwService.SWAPI_BASE_URL)
				.setPath(PlanetApiSwService.SWAPI_PLANETS_RESOURCE).addParameter("search", nome)
				.setCharset(Charset.forName("UTF-8"));

		PlanetApiSwResponseDTO results = restTemplate.getForObject(searchURL.build(), PlanetApiSwResponseDTO.class);

		if (results == null || results.getResults() == null)
			return new ArrayList<>();

		return Arrays.stream(results.getResults()).collect(Collectors.toList());
	}

}
