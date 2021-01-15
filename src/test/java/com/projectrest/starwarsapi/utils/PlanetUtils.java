package com.projectrest.starwarsapi.utils;

import com.projectrest.starwarsapi.dto.request.PlanetDTO;
import com.projectrest.starwarsapi.entity.Planet;

public class PlanetUtils {

    private static final String NAME = "Bespin";
    private static final String CLIMATE = "temperate";
    private static final String TERRAIN = "gas giant";
    private static final int   APPEARANCE = 1;
    private static final long  ID = 1L;

    public static PlanetDTO createFakeDTO() {
        return PlanetDTO.builder()
        		.id(ID)
        		.name(NAME)
        		.climate(CLIMATE)
        		.terrain(TERRAIN)
                .build();
    }

    public static Planet createFakeEntity() {
        return Planet.builder()
                .id(ID)
                .name(NAME)
        		.climate(CLIMATE)
        		.terrain(TERRAIN)
        		.appearance(APPEARANCE)
                .build();
    }
}
