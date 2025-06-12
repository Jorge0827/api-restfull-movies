package com.jechavarria.api_restfull_movies.config;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class ApiErrorResponse {
    // @JsonFormat asegura que la fecha se serialice a un formato legible por humanos
    // ISO 8601 es el estándar para fechas en APIs REST
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timeStamp; 
    private Integer status; // Código de estado HTTP numérico (ej: 400, 404)
    private String error; // La frase del estado HTTP (ej: "Bad Request", "Not Found")
    private String message; // Mensaje detallado del error para el cliente
    private String path; // La URI de la solicitud que causó el error

    public ApiErrorResponse(HttpStatus status, String message, String path){
        this.timeStamp = LocalDateTime.now(); // Obtiene la fecha y hora actual
        this.status = status.value(); // Convierte el enum HttpStatus a su valor numérico
        this.error = status.getReasonPhrase(); // Obtiene la frase descriptiva del HttpStatus
        this.message = message;
        this.path = path;
    }
 
}
