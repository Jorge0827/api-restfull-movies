package com.jechavarria.api_restfull_movies.exceptions;

public class ResourceNotfoundException extends RuntimeException{

    public ResourceNotfoundException(String message){
        super("El id de la pelicula que buscas no existe: " + message);

    }

}
