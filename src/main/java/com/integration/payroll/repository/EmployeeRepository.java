package com.integration.payroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.integration.payroll.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	List<Employee> findByIdEmployee(int idEmployee);
}
