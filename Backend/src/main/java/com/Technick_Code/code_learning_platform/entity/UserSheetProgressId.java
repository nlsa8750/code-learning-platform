package com.Technick_Code.code_learning_platform.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class UserSheetProgressId implements Serializable {
    
    @Column(name = "user_id", columnDefinition = "uuid")
    private UUID userId;

    @Column(name = "sheet_id")
    private Integer sheetId;

}