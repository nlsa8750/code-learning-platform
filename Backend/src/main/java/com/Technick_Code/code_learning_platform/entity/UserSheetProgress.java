package com.Technick_Code.code_learning_platform.entity;

import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;

import java.time.OffsetDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Entity
@Table(name = "user_sheet_progress")
@NoArgsConstructor
@AllArgsConstructor
public class UserSheetProgress {

    // jab do se zyada primary key ho toh composite key hai yeh, iske liye yeh
    @EmbeddedId
    private UserSheetProgressId id;

    // maps id map karta hai composite key ko isse map hone main 
    // many to one field ko map karta hai embeddedid se 
    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("user_id")
    @JoinColumn(name = "user_id", nullable = false)
    private Profile user;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("sheet_id")
    @JoinColumn(name = "sheet_id", nullable = false)
    private Sheet sheet;

    @Column(name = "solved_count")
    private Integer solvedCount = 0;

    @Column(name = "total_count")
    private Integer totalCount = 0;

    @Column(name = "last_updated")
    private OffsetDateTime lastUpdated;

}