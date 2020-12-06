package com.integration.hr.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integration.hr.model.Employment;

@Repository
public interface EmploymentRepository extends JpaRepository<Employment, Integer>{

}
