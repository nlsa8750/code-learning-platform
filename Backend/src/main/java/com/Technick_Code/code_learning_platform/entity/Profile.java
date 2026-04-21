package com.Technick_Code.code_learning_platform.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;
import java.time.LocalDate;
import lombok.Data;

@Data
@Entity
@Table(name = "profiles")
public class Profile {

    // uuid kyuki auth.users(id) supabase ka id type uuid hota hai jo woh khud handle karta hai 
    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(name = "full_name")
    private String fullName;

    @Column(columnDefinition = "TEXT", name = "avatar_url")
    private String avatarUrl;

    @Column(columnDefinition = "TEXT")
    private String bio;

    @Column(columnDefinition = "TEXT", name = "github_url")
    private String githubUrl;

    @Column(columnDefinition = "TEXT", name = "linkedin_url")
    private String linkedinUrl;

    // integer kyuki nullable hai
    @Column(name = "current_streak")
    private Integer currentStreak;

    @Column(name = "max_streak")
    private Integer maxStreak;

    @Column(name = "last_active_date")
    private LocalDate lastActiveDate;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;  


}