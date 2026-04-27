package com.Technick_Code.code_learning_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Technick_Code.code_learning_platform.entity.SheetProblem;

public interface SheetProblemRepository extends JpaRepository<SheetProblem, Integer> {
    
}
