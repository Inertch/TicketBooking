package com.example.projectplzwork.controllers;


import com.example.projectplzwork.entities.Movie;
import com.example.projectplzwork.entities.Ticket;
import com.example.projectplzwork.entities.TicketStatus;
import com.example.projectplzwork.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
private MovieService movieService;

@PreAuthorize("hasRole('ADMIN')")
@PostMapping("/admin/add-movie")
public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
    movie.setId(null);

    if (movie.getTickets() != null) {
        for (Ticket ticket : movie.getTickets()) {
            ticket.setMovie(movie);
            if (ticket.getStatus() == null) {
                ticket.setStatus(TicketStatus.AVAILABLE);
            }
        }
    }

    Movie savedMovie = movieService.saveMovie(movie);
    return ResponseEntity.ok(savedMovie);
}




@GetMapping
public List<Movie> getAllMovies() {
    return movieService.getAllMovies();
}

@GetMapping("/{id}")
public Optional<Movie> getMovieById(@PathVariable Long id) {
    return movieService.getMovieById(id);
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteMovie(@PathVariable Long id) {
    movieService.deleteMovie(id);
    return ResponseEntity.ok("Movie deleted successfully.");
}
}

