package com.example.projectplzwork.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "movie_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
}
