package com.projectrest.starwarsapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlanetApiSw {
	
    String name;
    String[] films;
}