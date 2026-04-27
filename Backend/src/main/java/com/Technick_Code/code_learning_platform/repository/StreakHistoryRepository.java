package com.Technick_Code.code_learning_platform.repository;

import java.util.Optional;
import java.util.UUID;
import java.util.List;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Technick_Code.code_learning_platform.entity.StreakHistory;

public interface StreakHistoryRepository extends JpaRepository<StreakHistory, Integer> {
    Optional<StreakHistory> findByUserIdAndDate(UUID userId, LocalDate date);
    List<StreakHistory> findByUserIdOrderByDateDesc(UUID userId);
}
