package com.Technick_Code.code_learning_platform.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "user_problem_progress")
@NoArgsConstructor
@AllArgsConstructor
public class UserProblemProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Profile user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "problem_id", nullable = false)
    private Problem problem;

    @Column(length = 20)
    private String status = "attempted";

    @Column(name = "is_bookmarked")
    private Boolean isBookMarked = false;

    @Column(columnDefinition = "TEXT")
    private String notes;

    @Column(name = "solved_at")
    private OffsetDateTime solvedAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

}