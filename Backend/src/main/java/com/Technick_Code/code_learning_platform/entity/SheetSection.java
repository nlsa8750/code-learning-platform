package com.Technick_Code.code_learning_platform.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.OffsetDateTime;
import jakarta.persistence.JoinColumn;

@Data
@Entity
@Table(name = "sheet_sections")
@NoArgsConstructor
@AllArgsConstructor
public class SheetSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sheet_id", nullable = false)
    private Sheet sheet;

    @Column(nullable = false, length = 200)
    private String title;
    
    @Column(nullable = false, name = "order_index")
    private int orderIndex;

    @Column(name = "created_at")
    private OffsetDateTime createdAt;

}