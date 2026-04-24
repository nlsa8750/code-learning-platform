package com.Technick_Code.code_learning_platform.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "streak_history")
@AllArgsConstructor
@NoArgsConstructor
public class StreakHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @Column(name = "user_id", nullable = false)
    private Profile user;

    @Column(nullable = false)
    private LocalDate date;

    @Column(name = "problems_solved")
    private Integer problemsSolved;

} 