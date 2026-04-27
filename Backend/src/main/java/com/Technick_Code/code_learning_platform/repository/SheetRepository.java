package com.Technick_Code.code_learning_platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Technick_Code.code_learning_platform.entity.Sheet;
import java.util.Optional;
import java.util.List;

public interface SheetRepository extends JpaRepository<Sheet, Integer> {

    Optional<Sheet> findBySlug(String slug);
    List<Sheet> findByIsPublishedTrue();

}