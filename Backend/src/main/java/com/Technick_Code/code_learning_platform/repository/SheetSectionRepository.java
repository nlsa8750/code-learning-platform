package com.Technick_Code.code_learning_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Technick_Code.code_learning_platform.entity.SheetSection;

public interface SheetSectionRepository extends JpaRepository<SheetSection, Integer> {
    
}