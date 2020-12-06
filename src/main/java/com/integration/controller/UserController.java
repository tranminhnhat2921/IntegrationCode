package com.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.payroll.model.Employee;
import com.integration.payroll.model.PayRate;
import com.integration.payroll.model.User;
import com.integration.payroll.repository.EmployeeRepository;
import com.integration.payroll.repository.PayRateRepository;
import com.integration.payroll.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private PayRateRepository payrateRepository;
	
	@GetMapping("/alluser")
	public Iterable<User> getAllUser() {
		return userRepository.findAll();
	}
		
	@GetMapping("/allemployee")
	public Iterable<Employee> getAllEmployee() {

		return employeeRepository.findAll();
	}
	
	@GetMapping("/allpayrate")
	public Iterable<PayRate> getAllPayrate() {

		return payrateRepository.findAll();
	}

}
