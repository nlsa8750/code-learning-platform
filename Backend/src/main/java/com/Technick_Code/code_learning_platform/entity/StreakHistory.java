package com.Technick_Code.code_learning_platform.entity;

import java.util.UUID;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "streak_history")

public class StreakHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    // user_id = profiles.id se link kar raha hai
    @Column(name = "user_id")
    private UUID userId;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "problems_solved")
    private Integer problemsSolved;

} 