package com.Technick_Code.code_learning_platform.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import com.Technick_Code.code_learning_platform.entity.Profile;
import java.util.Optional;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {

    Optional<Profile> findByUsername(String username);

}