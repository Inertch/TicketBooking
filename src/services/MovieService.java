package com.example.projectplzwork.services;

import com.example.projectplzwork.entities.Movie;
import com.example.projectplzwork.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    // Save Movie
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Get All Movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Get Movie by ID
    public Optional<Movie> getMovieById(Long id) {
        return movieRepository.findById(id);
    }

    // Delete Movie
    public void deleteMovie(Long id) {
        movieRepository.deleteById(id);
    }
}
