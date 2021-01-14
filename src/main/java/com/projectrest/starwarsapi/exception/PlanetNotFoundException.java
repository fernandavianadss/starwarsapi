package com.projectrest.starwarsapi.exception;

public class PlanetNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public PlanetNotFoundException(Long id) {
        super("Planet not found with id " + id);
    }
	
	public PlanetNotFoundException(String name) {
        super("Planet not found with name "+name);
    }
	
	public PlanetNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}
}
