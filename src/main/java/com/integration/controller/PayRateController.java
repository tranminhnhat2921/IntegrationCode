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

import com.integration.payroll.model.PayRate;
import com.integration.payroll.repository.PayRateRepository;

@RestController
@RequestMapping("/api")
public class PayRateController {

	@Autowired
	PayRateRepository payrateRepository;

	@CrossOrigin
	@GetMapping("/payrate")
	public ResponseEntity<List<PayRate>> getAllPayRate(@RequestParam(required = false) String name) {
		List<PayRate> list = new ArrayList<PayRate>();
		try {
			if (name == null)
				payrateRepository.findAll().forEach(list::add);
			//else
				//payrateRepository.findByName(name).forEach(list::add);
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
	@GetMapping("/payrate/{id}")
	public ResponseEntity<PayRate> getPayRateById(@RequestParam int id) {
		try {
			Optional<PayRate> payrate = payrateRepository.findById(id);
			if (payrate.isPresent()) {
				return new ResponseEntity<>(payrate.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@PostMapping("/payrate")
	public ResponseEntity<PayRate> createPayRate(@RequestBody PayRate payrate) {
		try {
			PayRate _payrate = payrateRepository.save(new PayRate(payrate.getPayRates_id(), payrate.getPay_Rate_Name(),
					payrate.getValue(), payrate.getTax_Percentage(), payrate.getPay_Type(), payrate.getPay_Amount(),
					payrate.getPT_Level_C()));
			return new ResponseEntity<>(_payrate, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@CrossOrigin
	@PutMapping("/payrate/{id}")
	public ResponseEntity<PayRate> updatePayRate(@PathVariable("id") int id, @RequestBody PayRate payrate) {
		Optional<PayRate> payrateData = payrateRepository.findById(id);
		if (payrateData.isPresent()) {
			PayRate _payrate = payrateData.get();
			_payrate.setPay_Rate_Name(payrate.getPay_Rate_Name());
			_payrate.setValue(payrate.getValue());
			_payrate.setTax_Percentage(payrate.getTax_Percentage());
			_payrate.setPay_Type(payrate.getPay_Type());
			_payrate.setPay_Amount(payrate.getPay_Amount());
			_payrate.setPT_Level_C(payrate.getPT_Level_C());
			return new ResponseEntity<>(payrateRepository.save(_payrate), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@DeleteMapping("/payrate/{id}")
	public ResponseEntity<HttpStatus> deletePayRate(@PathVariable("id") int id) {
		try {
			payrateRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
