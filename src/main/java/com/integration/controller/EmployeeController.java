package com.integration.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.integration.payroll.model.Employee;
import com.integration.payroll.repository.EmployeeRepository;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@CrossOrigin
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getAllEmployee(@RequestParam(required = false) String emId) {
		List<Employee> list = new ArrayList<Employee>();
		try {
			if (emId == null)
				employeeRepository.findAll().forEach(list::add);
			else
				employeeRepository.findByIdEmployee(Integer.parseInt(emId)).forEach(list::add);
			if (list.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@GetMapping("/employee/{id}")
	public ResponseEntity<Employee> getEmployeeById(@RequestParam int id) {
		try {
			Optional<Employee> employee = employeeRepository.findById(id);
			if (employee.isPresent()) {
				return new ResponseEntity<>(employee.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
		try {
			Employee _employee = employeeRepository.save(new Employee(employee.getEmployee_Number(),
					employee.getIdEmployee(), employee.getFirst_Name(), employee.getLast_Name(), employee.getSSN(),
					employee.getPay_Rate(), employee.getPayRates_id(), employee.getVacation_Days(),
					employee.getPaid_To_Date(), employee.getPaid_Last_Year()));
			return new ResponseEntity<>(_employee, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") int id, @RequestBody Employee employee) {
		Optional<Employee> employeeData = employeeRepository.findById(id);
		if (employeeData.isPresent()) {
			Employee _emloyee = employeeData.get();
			_emloyee.setIdEmployee(employee.getEmployee_Number());
			_emloyee.setFirst_Name(employee.getFirst_Name());
			_emloyee.setLast_Name(employee.getLast_Name());
			_emloyee.setSSN(employee.getSSN());
			_emloyee.setPay_Rate(employee.getPay_Rate());
			_emloyee.setPayRates_id(employee.getPayRates_id());
			_emloyee.setVacation_Days(employee.getVacation_Days());
			_emloyee.setPaid_To_Date(employee.getPaid_To_Date());
			_emloyee.setPaid_Last_Year(employee.getPaid_Last_Year());
			return new ResponseEntity<>(employeeRepository.save(_emloyee), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") int id) {
		try {
			employeeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
