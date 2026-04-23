package com.Technick_Code.code_learning_platform.entity;

import java.time.OffsetDateTime;

// jpa manage karta hai relational database java app main
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// apne aap getters , setters bana dega 
@Data
@Entity
@Table(name = "problems")
@NoArgsConstructor
@AllArgsConstructor
public class Problem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 300)
    private String title;

    @Column(nullable = false, unique = true, length = 300)
    private String slug;

    @Column(nullable = false, length = 10)
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

    @Column(name = "primary_platform", length = 20)
    private String primaryPlatform = "leetcode";

    // boolean nahi Boolean kyuki nullable hai
    private Boolean ispremium = false;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

}