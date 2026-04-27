package com.Technick_Code.code_learning_platform.repository;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Technick_Code.code_learning_platform.entity.Problem;

import java.util.List;
import java.util.Optional;

public interface ProblemRepository extends JpaRepository<Problem, Integer> {

    Optional<Problem> findBySlug(String slug);
    List<Problem> findByDifficulty(String difficulty);
    List<Problem> findAll(Pageable pageable); // for pagination

}