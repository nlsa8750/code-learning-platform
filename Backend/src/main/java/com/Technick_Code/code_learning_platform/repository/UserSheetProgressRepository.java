package com.Technick_Code.code_learning_platform.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Technick_Code.code_learning_platform.entity.UserSheetProgress;
import com.Technick_Code.code_learning_platform.entity.UserSheetProgressId;

public interface UserSheetProgressRepository extends JpaRepository<UserSheetProgress, UserSheetProgressId>{
    Optional<UserSheetProgress> findById(UserSheetProgressId id);
    List<UserSheetProgress> findByUserId(UUID userId);

}
