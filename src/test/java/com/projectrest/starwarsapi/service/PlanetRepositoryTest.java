package com.projectrest.starwarsapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.projectrest.starwarsapi.dto.request.PlanetDTO;
import com.projectrest.starwarsapi.dto.response.MessageResponseDTO;
import com.projectrest.starwarsapi.entity.Planet;
import com.projectrest.starwarsapi.exception.PlanetNotFoundException;
import com.projectrest.starwarsapi.repository.PlanetRepository;
import com.projectrest.starwarsapi.utils.PlanetUtils;

@ExtendWith(MockitoExtension.class)
public class PlanetRepositoryTest {
	
	@Mock
    private PlanetRepository planetRepository;

    @InjectMocks
    private PlanetService planetService;
    
    @Mock
    private PlanetApiSwService planetApiSwService;

    @Test
    void testGivenPlanetDTOThenReturnSavedMessage() throws PlanetNotFoundException, URISyntaxException {
        PlanetDTO planetDTO = PlanetUtils.createFakeDTO();
        Planet expectedSavedPlanet = PlanetUtils.createFakeEntity();

        when(planetRepository.save(any(Planet.class))).thenReturn(expectedSavedPlanet);

        MessageResponseDTO expectedSuccessMessage = createExpectedMessageResponse(expectedSavedPlanet.getId());
        MessageResponseDTO succesMessage = planetService.createPlanet(planetDTO);

        assertEquals(expectedSuccessMessage, succesMessage);
    }

    private MessageResponseDTO createExpectedMessageResponse(Long id) {
        return MessageResponseDTO
                .builder()
                .message("Created planet with id " + id)
                .build();
    }
}
