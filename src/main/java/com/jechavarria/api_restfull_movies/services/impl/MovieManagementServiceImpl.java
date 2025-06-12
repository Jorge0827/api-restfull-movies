package com.jechavarria.api_restfull_movies.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jechavarria.api_restfull_movies.exceptions.MovieAlreadyExistsException;
import com.jechavarria.api_restfull_movies.exceptions.ResourceNotfoundException;
import com.jechavarria.api_restfull_movies.mapper.MovieMapper;
import com.jechavarria.api_restfull_movies.models.dtos.MovieRequest;
import com.jechavarria.api_restfull_movies.models.dtos.MovieResponse;
import com.jechavarria.api_restfull_movies.models.entity.Movie;
import com.jechavarria.api_restfull_movies.repository.MovieRepository;
import com.jechavarria.api_restfull_movies.services.MovieService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MovieManagementServiceImpl implements MovieService{

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;
    
    @Override
    public MovieResponse createMovie(MovieRequest movieDto) {
        // Verificar si ya existe una película con el mismo título
        if (movieRepository.findByTitle(movieDto.getTitle()).isPresent()) {
            throw new MovieAlreadyExistsException(movieDto.getTitle());
        }
        // Convertir DTO a entidad
        Movie movie = movieMapper.MovieRequestToMovie(movieDto);
        // Guardar la película
        Movie savedMovie = movieRepository.save(movie);
        // Convertir entidad guardada a DTO de respuesta
        return movieMapper.MovieToMovieResponse(savedMovie);
    }

    @Override
    public MovieResponse getMovieById(Long id) {
        // Busca la película por su ID en el repositorio
        // Si no la encuentra, lanza una excepción personalizada
        Movie movie = movieRepository.findById(id)
            .orElseThrow(() -> new ResourceNotfoundException("No se ha encontrado una pelicula"));
        // Convierte la entidad Movie a un DTO MovieResponse usando el mapper
        return movieMapper.MovieToMovieResponse(movie);
    }

    @Override
    public List<MovieResponse> getAllMovies(String director, String genre) {
        // Lista que almacenará las películas encontradas
        List<Movie> movies;
        // Si se proporciona un director, busca películas que contengan ese director
        if (director != null && !director.trim().isEmpty()) {
            // findByDirectorContainingIgnoreCase busca coincidencias parciales ignorando mayúsculas/minúsculas
            movies = movieRepository.findByDirectorContainingIgnoreCase(director);
        } 
        // Si no hay director pero hay género, busca películas por género
        else if (genre != null && !genre.trim().isEmpty()) {
            // findByGenreIgnoreCase busca coincidencias exactas ignorando mayúsculas/minúsculas
            movies = movieRepository.findByGenreIgnoreCase(genre);
        } 
        // Si no se proporciona ni director ni género, devuelve todas las películas
        else {
            movies = movieRepository.findAll();
        }
        // Convierte cada película encontrada a un objeto MovieResponse usando el mapper
        return movies.stream()
                .map(movieMapper::MovieToMovieResponse)
                .toList();
    }

    @Override
    public MovieResponse updateMovie(Long id, MovieRequest movieDto) {
        var entityOptional = movieRepository.findById(id);
        if (!entityOptional.isPresent()) {
            throw new ResourceNotfoundException("No se encontró la pelicula"); 
        }
        Movie movie = entityOptional.get();
        // Actualizar los campos de la película con los datos del DTO
        movie.setTitle(movieDto.getTitle());
        movie.setDirector(movieDto.getDirector());
        movie.setGenre(movieDto.getGenre());
        movie.setReleaseYear(movieDto.getReleaseYear());
        movie.setImdbRating(movieDto.getImdbRating());
        // Guardar la película actualizada
        Movie updatedMovie = movieRepository.save(movie);
        // Convertir y retornar la película actualizada como MovieResponse
        return movieMapper.MovieToMovieResponse(updatedMovie);
    }

    @Override
    public void deleteMovie(Long id) {
        if (!movieRepository.existsById(id)) { //existsById lo que hace es verificar si existe o no
            throw new ResourceNotfoundException("No se encontró la pelicula");
        }
        movieRepository.deleteById(id);
    }

}
