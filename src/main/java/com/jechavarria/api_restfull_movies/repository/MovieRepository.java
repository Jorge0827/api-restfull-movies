package com.jechavarria.api_restfull_movies.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jechavarria.api_restfull_movies.models.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie>findByDirectorContainingIgnoreCase(String director);
    List<Movie> findByGenreIgnoreCase(String genre);
    Optional<Movie> findByTitle(String title); //(Necesario para verificar títulos duplicados).

}
