package com.jechavarria.api_restfull_movies.exceptions;

public class MovieAlreadyExistsException extends RuntimeException {
    
    public MovieAlreadyExistsException(String title) {
        super("Ya existe una película con el título: " + title);
    }
} 