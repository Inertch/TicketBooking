package com.example.projectplzwork.controllers;

import com.example.projectplzwork.entities.Movie;
import com.example.projectplzwork.entities.Ticket;
import com.example.projectplzwork.entities.TicketStatus;
import com.example.projectplzwork.services.MovieService;
import com.example.projectplzwork.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
    public ResponseEntity<List<Ticket>> getAllTickets() {
        return ResponseEntity.ok(ticketService.getAllTickets());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.getTicketById(id);
        return ticket.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Ticket> createTicket(@RequestBody Map<String, Object> payload) {
        Long movieId = ((Number) payload.get("movieId")).longValue();

        Ticket ticket = new Ticket();
        ticket.setSeatNumber((String) payload.get("seatNumber"));
        ticket.setPrice(((Number) payload.get("price")).doubleValue());

        ticket.setStatus(TicketStatus.valueOf((String) payload.get("status").toString().toUpperCase()));

        Ticket savedTicket = ticketService.saveTicket(ticket, movieId);
        return ResponseEntity.ok(savedTicket);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTicket(@PathVariable Long id) {
        ticketService.deleteTicket(id);
        return ResponseEntity.noContent().build();
    }
}
