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

public Movie saveMovie(Movie movie) {
    return movieRepository.save(movie);
}

public Movie updateMovie(Long id, Movie updatedMovie) {
    return movieRepository.findById(id).map(movie -> {
        movie.setTitle(updatedMovie.getTitle());
        movie.setGenre(updatedMovie.getGenre());
        movie.setDateTime(updatedMovie.getDateTime());
        movie.setScreen(updatedMovie.getScreen());
        return movieRepository.save(movie);
    }).orElseThrow(() -> new RuntimeException("Movie with ID " + id + " not found"));
}


public List<Movie> getAllMovies() {
    return movieRepository.findAll();
}

public Optional<Movie> getMovieById(Long id) {
    return movieRepository.findById(id);
}

public void deleteMovie(Long id) {
    movieRepository.deleteById(id);
}
}
