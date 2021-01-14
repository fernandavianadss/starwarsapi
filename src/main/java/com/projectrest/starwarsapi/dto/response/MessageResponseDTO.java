package com.projectrest.starwarsapi.dto.response;

import java.io.Serializable;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MessageResponseDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String message;
}
