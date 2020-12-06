package com.integration.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.integration.hr.model.Personal;
import com.integration.hr.repository.PersonalRepository;

@RestController
public class HRController {

	@Autowired
	PersonalRepository personalRepository;
	
	@GetMapping("/allpersonal")
	public Iterable<Personal> getAllPersonal() {
		return personalRepository.findAll();
	}
}
