package com.example.projectplzwork.repositories;

import com.example.projectplzwork.entities.Movie;
import com.example.projectplzwork.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    @Query("SELECT m FROM Movie m LEFT JOIN FETCH m.tickets WHERE m.dateTime = :dateTime")
    List<Movie> findMoviesByDateTime(@Param("dateTime") LocalDateTime dateTime);
}

