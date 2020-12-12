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

import com.integration.hr.model.EmergencyContacts;
import com.integration.hr.repository.EmergencyContactsRepository;

@RestController
@RequestMapping("/api")
public class EmergencyContactsController {

	@Autowired
	EmergencyContactsRepository emergencyContactsRepository;

	@CrossOrigin
	@GetMapping("/emergencycontacts")
	public ResponseEntity<List<EmergencyContacts>> getAllEmergencyContacts(
			@RequestParam(required = false) String emId) {
		List<EmergencyContacts> list = new ArrayList<EmergencyContacts>();
		try {
			if (emId == null)
				emergencyContactsRepository.findAll().forEach(list::add);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@GetMapping("/emergencycontacts/{id}")
	public ResponseEntity<EmergencyContacts> getEmergencyContactsById(@PathVariable("id") BigDecimal id) {
		try {
			Optional<EmergencyContacts> emergencyContacts = emergencyContactsRepository.findById(id);
			if (emergencyContacts.isPresent()) {
				return new ResponseEntity<>(emergencyContacts.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@PostMapping("/emergencycontacts")
	public ResponseEntity<EmergencyContacts> createEmergencyContacts(@RequestBody EmergencyContacts emergencyContacts) {
		try {
			EmergencyContacts _emergencyContacts = emergencyContactsRepository.save(new EmergencyContacts(
					emergencyContacts.getEmployee_ID(), emergencyContacts.getEmergency_Contact_Name(),
					emergencyContacts.getPhone_Number(), emergencyContacts.getRelationship()));
			return new ResponseEntity<>(_emergencyContacts, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@PutMapping("/emergencycontacts/{id}")
	public ResponseEntity<EmergencyContacts> updateEmergencyContacts(@PathVariable("id") BigDecimal id,
			@RequestBody EmergencyContacts emergencyContacts) {
		Optional<EmergencyContacts> emergencyContactsData = emergencyContactsRepository.findById(id);
		if (emergencyContactsData.isPresent()) {
			EmergencyContacts _emergencyContacts = emergencyContactsData.get();
			_emergencyContacts.setEmployee_ID(emergencyContacts.getEmployee_ID());
			_emergencyContacts.setEmergency_Contact_Name(emergencyContacts.getEmergency_Contact_Name());
			_emergencyContacts.setPhone_Number(emergencyContacts.getPhone_Number());
			_emergencyContacts.setRelationship(emergencyContacts.getRelationship());
			return new ResponseEntity<>(emergencyContactsRepository.save(_emergencyContacts), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@DeleteMapping("/emergencycontacts/{id}")
	public ResponseEntity<HttpStatus> deleteEmergencyContacts(@PathVariable("id") BigDecimal id) {
		try {
			emergencyContactsRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
