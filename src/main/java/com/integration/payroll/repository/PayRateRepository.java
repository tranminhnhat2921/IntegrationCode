package com.integration.payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integration.payroll.model.PayRate;

@Repository
public interface PayRateRepository extends JpaRepository<PayRate, Integer>{
	//List<PayRate> findByNamePayRate(String Pay_Rate_Name);
}
