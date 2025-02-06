package com.example.projectplzwork.repositories;

import com.example.projectplzwork.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

    @Query("SELECT t FROM Ticket t JOIN FETCH t.movie WHERE t.movie.dateTime = :dateTime")
    List<Ticket> findTicketsByMovieDateTime(@Param("dateTime") LocalDateTime dateTime);

}
