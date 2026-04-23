package com.Technick_Code.code_learning_platform.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.time.OffsetDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "sheets")
@NoArgsConstructor
@AllArgsConstructor
public class Sheet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String title;

    @Column(nullable = false, unique = true)
    private String slug;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(columnDefinition = "TEXT", name = "cover_image_url")
    private String coverImageUrl;

    @Column(name = "is_published")
    private Boolean isPublished;

    // @Column(name = "created_by")
    // private UUID createdBy;

    // fetch tab hoga jab uska istmal karenge
    // jpa join kar dega profiles table se 
    // phir uske baad query run hogi sheet.getCreatedBy().getName()
    // phir lazy fetch -> phir createdBy = profileObject
    // purpose taaki main profile ka data render kara saku.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "created_by")
    private Profile createdBy;

    @Column(name = "total_problems")
    private Integer totalProblems = 0;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

    @Column(name = "updated_at")
    private OffsetDateTime updatedAt;

}