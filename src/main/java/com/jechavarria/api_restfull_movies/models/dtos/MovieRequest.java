package com.jechavarria.api_restfull_movies.models.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieRequest {

    @NotBlank(message = "El título es obligatorio.")
    @Size(min = 2, max = 255, message = "El título debe tener entre 2 y 255 caracteres.")
    private String title;

    @NotBlank(message = "El director es obligatorio.")
    @Size(min = 2, max = 100, message = "El director debe tener entre 2 y 100 caracteres.")
    private String director;

    @NotBlank(message = "El género es obligatorio.")
    @Pattern(regexp = "^(Action|Comedy|Drama|Horror|Sci-Fi|Thriller|Animation|Documentary)$", 
            message = "Género no válido. Debe ser uno de los predefinidos.")
    private String genre;

    @NotNull(message = "El año de lanzamiento es obligatorio.")
    @Min(value = 1888, message = "El año de lanzamiento no puede ser anterior a 1888 (inicio del cine).")
    @Max(value = 2025, message = "El año de lanzamiento no puede ser posterior al año actual (2025).")
    @JsonProperty("year_released")
    private Integer releaseYear;

    @Min(value = 1, message = "La calificación IMDb debe ser al menos 1.0.")
    @Max(value = 10, message = "La calificación IMDb no puede exceder 10.0.")
    @JsonProperty("imdb_score")
    private Double imdbRating;

}
