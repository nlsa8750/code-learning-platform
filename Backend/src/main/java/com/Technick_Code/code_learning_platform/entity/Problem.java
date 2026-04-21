package com.Technick_Code.code_learning_platform.entity;

import java.time.LocalDateTime;

// jpa manage karta hai relational database java app main
import jakarta.persistence.*;
import lombok.Data;

// apne aap getters , setters bana dega 
@Data
@Entity
@Table(name = "problems")
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(nullable = false)
    private String difficulty;

    // name = supabase k columns se match k liye
    @Column(columnDefinition = "TEXT", name = "leetcode_url")
    private String leetcodeUrl;

    @Column(columnDefinition = "TEXT", name = "gfg_url")
    private String gfgUrl;

    @Column(columnDefinition = "TEXT", name = "hackerearth_url")
    private String hackerearthUrl;

    @Column(columnDefinition = "TEXT", name = "codeforces_url")
    private String codeforcesUrl;

    @Column(columnDefinition = "TEXT", name = "codestudio_url")
    private String codestudioUrl;

    @Column(name = "primary_platform")
    private String primaryPlatform;

    // boolean nahi Boolean kyuki nullable hai
    private Boolean ispremium;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}