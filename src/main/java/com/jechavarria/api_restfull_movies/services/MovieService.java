package com.jechavarria.api_restfull_movies.services;

import java.util.List;

import com.jechavarria.api_restfull_movies.models.dtos.MovieRequest;
import com.jechavarria.api_restfull_movies.models.dtos.MovieResponse;

public interface MovieService {
    
        MovieResponse createMovie(MovieRequest movieDto);
        MovieResponse getMovieById(Long id);
        List<MovieResponse> getAllMovies(String director, String genre);
        MovieResponse updateMovie(Long id, MovieRequest movieDto);
        void deleteMovie(Long id);
    }

    

