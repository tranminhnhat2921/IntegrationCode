package com.integration.payroll.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integration.payroll.model.PayRate;

@Repository
public interface PayRateRepository extends JpaRepository<PayRate, Integer>{
	
}
