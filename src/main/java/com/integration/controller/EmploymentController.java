package com.integration.controller;

import java.math.BigDecimal;
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

import com.integration.hr.model.Employment;
import com.integration.hr.repository.EmploymentRepository;

@RestController
@RequestMapping("/api")
public class EmploymentController {

	@Autowired
	EmploymentRepository employmentRepository;

	@CrossOrigin
	@GetMapping("/employment")
	public ResponseEntity<List<Employment>> getAllEmployment(@RequestParam(required = false) String emId) {
		List<Employment> list = new ArrayList<Employment>();
		try {
			if (emId == null)
				employmentRepository.findAll().forEach(list::add);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@GetMapping("/employment/{id}")
	public ResponseEntity<Employment> getEmploymentById(@PathVariable("id") BigDecimal id) {
		try {
			Optional<Employment> employment = employmentRepository.findById(id);
			if (employment.isPresent()) {
				return new ResponseEntity<>(employment.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@PostMapping("/employment")
	public ResponseEntity<Employment> createEmployment(@RequestBody Employment employment) {
		try {
			Employment _employment = employmentRepository.save(new Employment(employment.getEmployee_ID(),
					employment.getEmployment_Status(), employment.getHire_Date(), employment.getWorkers_Comp_Code(),
					employment.getTermination_Date(), employment.getRehire_Date(), employment.getLast_Review_Date()));
			return new ResponseEntity<>(_employment, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@PutMapping("/employment/{id}")
	public ResponseEntity<Employment> updateBenefitPlans(@PathVariable("id") BigDecimal id,
			@RequestBody Employment employment) {
		Optional<Employment> employmentData = employmentRepository.findById(id);
		if (employmentData.isPresent()) {
			Employment _employment = employmentData.get();
			_employment.setEmployee_ID(employment.getEmployee_ID());
			_employment.setEmployment_Status(employment.getEmployment_Status());
			_employment.setHire_Date(employment.getHire_Date());
			_employment.setWorkers_Comp_Code(employment.getWorkers_Comp_Code());
			_employment.setTermination_Date(employment.getTermination_Date());
			_employment.setRehire_Date(employment.getRehire_Date());
			_employment.setLast_Review_Date(employment.getLast_Review_Date());
			return new ResponseEntity<>(employmentRepository.save(_employment), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@DeleteMapping("/employment/{id}")
	public ResponseEntity<HttpStatus> deleteBenefitPlans(@PathVariable("id") BigDecimal id) {
		try {
			employmentRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
