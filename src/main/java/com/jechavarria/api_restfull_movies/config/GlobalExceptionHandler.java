package com.jechavarria.api_restfull_movies.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jechavarria.api_restfull_movies.exceptions.MovieAlreadyExistsException;
import com.jechavarria.api_restfull_movies.exceptions.ResourceNotfoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice // se manejarán excpeciones globales para todos los ocntroladores
public class GlobalExceptionHandler {

    @ExceptionHandler(MovieAlreadyExistsException.class) // manejaá específicamente esat excpecion
    public ResponseEntity<ApiErrorResponse> handleMovieAlreadyExist(MovieAlreadyExistsException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.CONFLICT)
        .body(new ApiErrorResponse(HttpStatus.CONFLICT, ex.getMessage(), request.getRequestURI()));
    }
    @ExceptionHandler(ResourceNotfoundException.class) // manejara específicamente esat excpecion
    public ResponseEntity<ApiErrorResponse> handleResourseNotFound(ResourceNotfoundException ex, HttpServletRequest request){
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
        .body(new ApiErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage(), request.getRequestURI()));
    }

    @ExceptionHandler(RuntimeException.class) //Responde a tda Reuntime
    public ResponseEntity<Void> handleRuntimeException(RuntimeException ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }

    @ExceptionHandler(Exception.class) //Responde a toda Exception
    public ResponseEntity<Void> handleException(Exception ex){
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
    }


}
