package com.projectrest.starwarsapi.exception;

public class SwapiException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public SwapiException(String name) {
        super("Planet not found with name "+name);
    }
	
	public SwapiException(String message, Throwable cause) {
		super(message, cause);
	}

}
