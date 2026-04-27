package com.Technick_Code.code_learning_platform.repository;

import java.util.Optional;
import java.util.UUID;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Technick_Code.code_learning_platform.entity.UserProblemProgress;

public interface UserProblemProgressRepository extends JpaRepository<UserProblemProgress, Integer>{
    
    Optional<UserProblemProgress> findByUserIdAndProblemId(UUID userId, Integer problemId);
    List<UserProblemProgress> findByUserId(UUID userId);
    List<UserProblemProgress> findByUserIdAndStatus(UUID userId, String status);
    long countByUserIdAndStatus(UUID userId, String status);

}
