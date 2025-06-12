package com.jechavarria.api_restfull_movies.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jechavarria.api_restfull_movies.models.dtos.MovieRequest;
import com.jechavarria.api_restfull_movies.models.dtos.MovieResponse;
import com.jechavarria.api_restfull_movies.services.MovieService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * Controlador REST para gestionar las operaciones CRUD de películas
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    
    @PostMapping("/create")
    public ResponseEntity<Void> createMovie(@Valid @RequestBody MovieRequest movieDto) {
        movieService.createMovie(movieDto);
        return ResponseEntity.status(HttpStatus.CREATED).build(); 
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<MovieResponse> getMovieById(@Valid @PathVariable Long id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }


    @GetMapping
    public ResponseEntity<List<MovieResponse>> getAllMovies(
            @RequestParam(required = false) String director,
            @RequestParam(required = false) String genre) {
        return ResponseEntity.ok(movieService.getAllMovies(director, genre));
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<MovieResponse> updateMovie(@PathVariable Long id, @Valid @RequestBody MovieRequest movieDto) {
        return ResponseEntity.ok(movieService.updateMovie(id, movieDto));
    }

    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }
}
