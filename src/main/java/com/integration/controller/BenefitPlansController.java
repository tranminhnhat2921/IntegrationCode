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

import com.integration.hr.model.BenefitPlans;
import com.integration.hr.repository.BenefitPlansRepository;

@RestController
@RequestMapping("/api")
public class BenefitPlansController {
	@Autowired
	BenefitPlansRepository benefitPlansRepository;

	@CrossOrigin
	@GetMapping("/benefitplans")
	public ResponseEntity<List<BenefitPlans>> getAllBenefitPlans(@RequestParam(required = false) String emId) {
		List<BenefitPlans> list = new ArrayList<BenefitPlans>();
		try {
			if (emId == null)
				benefitPlansRepository.findAll().forEach(list::add);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@GetMapping("/benefitplans/{id}")
	public ResponseEntity<BenefitPlans> getBenefitPlansById(@PathVariable("id") BigDecimal id) {
		try {
			Optional<BenefitPlans> benefitPlans = benefitPlansRepository.findById(id);
			if (benefitPlans.isPresent()) {
				return new ResponseEntity<>(benefitPlans.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@PostMapping("/benefitplans")
	public ResponseEntity<BenefitPlans> createBenefitPlans(@RequestBody BenefitPlans benefitPlans) {
		try {
			BenefitPlans _benefitPlans = benefitPlansRepository.save(new BenefitPlans(benefitPlans.getPlan_Name(),
					benefitPlans.getDeductable(), benefitPlans.getPercentage_CoPay()));
			return new ResponseEntity<>(_benefitPlans, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@PutMapping("/benefitplans/{id}")
	public ResponseEntity<BenefitPlans> updateBenefitPlans(@PathVariable("id") BigDecimal id,
			@RequestBody BenefitPlans benefitPlans) {
		Optional<BenefitPlans> benefitPlansData = benefitPlansRepository.findById(id);
		if (benefitPlansData.isPresent()) {
			BenefitPlans _benefitPlans = benefitPlansData.get();
			_benefitPlans.setPlan_Name(benefitPlans.getPlan_Name());
			_benefitPlans.setDeductable(benefitPlans.getDeductable());
			_benefitPlans.setPercentage_CoPay(benefitPlans.getPercentage_CoPay());
			return new ResponseEntity<>(benefitPlansRepository.save(_benefitPlans), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@DeleteMapping("/benefitplans/{id}")
	public ResponseEntity<HttpStatus> deleteBenefitPlans(@PathVariable("id") BigDecimal id) {
		try {
			benefitPlansRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
