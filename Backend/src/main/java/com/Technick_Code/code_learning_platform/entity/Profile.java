package com.Technick_Code.code_learning_platform.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.util.UUID;
import java.time.LocalDate;
import java.time.OffsetDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@Table(name = "profiles")
@NoArgsConstructor // taaki jpa jab object create karta hai toh iski zaroorat pade, json se object main bhi kaam aata hai, request and response body main zaroori
@AllArgsConstructor // yeh toh jab mereko manually object karna ho
public class Profile {

    // uuid kyuki auth.users(id) supabase ka id type uuid hota hai
    // generatedValue nahi lagaya kyuki supabase khud create karega
    @Id
    @Column(columnDefinition = "uuid")
    private UUID id;

    @Column(nullable = false, unique = true, length = 50)
    private String username;

    @Column(name = "full_name", length = 100)
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
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;  


}