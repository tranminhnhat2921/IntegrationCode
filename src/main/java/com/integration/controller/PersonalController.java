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

import com.integration.hr.model.Personal;
import com.integration.hr.repository.PersonalRepository;

@RestController
@RequestMapping("/api")
public class PersonalController {

	@Autowired
	PersonalRepository personalRepository;

	@CrossOrigin
	@GetMapping("/personal")
	public ResponseEntity<List<Personal>> getAllPersonal(@RequestParam(required = false) String emId) {
		List<Personal> list = new ArrayList<Personal>();
		try {
			if (emId == null)
				personalRepository.findAll().forEach(list::add);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@GetMapping("/personal/{id}")
	public ResponseEntity<Personal> getPersonalById(@PathVariable("id") BigDecimal id) {
		try {
			Optional<Personal> personal = personalRepository.findById(id);
			if (personal.isPresent()) {
				return new ResponseEntity<>(personal.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@PostMapping("/personal")
	public ResponseEntity<Personal> createPersonal(@RequestBody Personal personal) {
		try {
			Personal _personal = personalRepository
					.save(new Personal(personal.getEmployee_ID(), personal.getFirst_Name(), personal.getLast_Name(),
							personal.getMiddle_Initial(), personal.getAddress1(), personal.getAddress2(),
							personal.getCity(), personal.getState(), personal.getZip(), personal.getEmail(),
							personal.getPhone_Number(), personal.getSocial_Security_Number(),
							personal.getDrivers_License(), personal.getMarital_Status(), personal.isGender(),
							personal.isShareholder_Status(), personal.getBenefit_Plans(), personal.getEthnicity()));
			return new ResponseEntity<>(_personal, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@PutMapping("/personal/{id}")
	public ResponseEntity<Personal> updatePersonal(@PathVariable("id") BigDecimal id, @RequestBody Personal personal) {
		Optional<Personal> personalData = personalRepository.findById(id);
		if (personalData.isPresent()) {
			Personal _personal = personalData.get();
			_personal.setEmployee_ID(personal.getEmployee_ID());
			_personal.setFirst_Name(personal.getFirst_Name());
			_personal.setLast_Name(personal.getFirst_Name());
			_personal.setMiddle_Initial(personal.getLast_Name());
			_personal.setAddress1(personal.getAddress1());
			_personal.setAddress2(personal.getAddress2());
			_personal.setCity(personal.getCity());
			_personal.setState(personal.getState());
			_personal.setZip(personal.getZip());
			_personal.setEmail(personal.getEmail());
			_personal.setPhone_Number(personal.getPhone_Number());
			_personal.setSocial_Security_Number(personal.getSocial_Security_Number());
			_personal.setDrivers_License(personal.getDrivers_License());
			_personal.setMarital_Status(personal.getMarital_Status());
			_personal.setGender(personal.isGender());
			_personal.setShareholder_Status(personal.isShareholder_Status());
			_personal.setBenefit_Plans(personal.getBenefit_Plans());
			_personal.setEthnicity(personal.getEthnicity());
			return new ResponseEntity<>(personalRepository.save(_personal), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@DeleteMapping("/personal/{id}")
	public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable("id") BigDecimal id) {
		try {
			personalRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
