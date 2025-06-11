package com.jechavarria.api_restfull_movies.models.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieResponse {
    
    private Long id;
    
    private String title;
    
    private String director;
    
    private String genre;
    
    @JsonProperty("year_released")
    private Integer releaseYear;
    
    @JsonProperty("imdb_score")
    private Double imdbRating;
} 