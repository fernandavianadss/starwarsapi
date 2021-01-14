package com.projectrest.starwarsapi.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PlanetDTO {
	
	@JsonIgnore
	private Long id;
	
	@NotEmpty
    @Size(min = 2, max = 100)
	private String name;
	
	@NotEmpty
    @Size(min = 2, max = 100)
	private String climate;
	
	@NotEmpty
    @Size(min = 2, max = 100)
	private String terrain;
}
