package com.Technick_Code.code_learning_platform.repository;

import com.Technick_Code.code_learning_platform.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Integer>{
    
}
