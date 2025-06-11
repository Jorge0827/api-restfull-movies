package com.jechavarria.api_restfull_movies.mapper;

import org.springframework.stereotype.Component;

import com.jechavarria.api_restfull_movies.models.dtos.MovieRequest;
import com.jechavarria.api_restfull_movies.models.dtos.MovieResponse;
import com.jechavarria.api_restfull_movies.models.entity.Movie;

@Component
public class MovieMapper {

    public Movie MovieRequestToMovie(MovieRequest movie){
        var response = new Movie();
        response.setTitle(movie.getTitle());
        response.setDirector(movie.getDirector());
        response.setGenre(movie.getGenre());
        response.setReleaseYear(movie.getReleaseYear());
        response.setImdbRating(movie.getImdbRating());
        return response;
    }

    public MovieResponse MovieToMovieResponse(Movie movie) {
        var response = new MovieResponse();
        response.setId(movie.getId());
        response.setTitle(movie.getTitle());
        response.setDirector(movie.getDirector());
        response.setGenre(movie.getGenre());
        response.setReleaseYear(movie.getReleaseYear());
        response.setImdbRating(movie.getImdbRating());
        return response;
    }
}
