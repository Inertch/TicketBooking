package com.example.projectplzwork.utils;

import com.example.projectplzwork.entities.Movie;
import java.time.LocalDateTime;
import java.util.function.Supplier;

public class MovieFactory {
    public static Movie createMovie(String title, String genre, LocalDateTime dateTime, String screen) {
        Supplier<Movie> movieSupplier = () -> Movie.builder()
                .title(title)
                .genre(genre)
                .dateTime(dateTime)
                .screen(screen)
                .build();
        return movieSupplier.get();
    }
}
