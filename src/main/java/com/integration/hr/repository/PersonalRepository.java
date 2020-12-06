package com.integration.hr.repository;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integration.hr.model.Personal;

@Repository
public interface PersonalRepository extends JpaRepository<Personal, BigDecimal>{

}
