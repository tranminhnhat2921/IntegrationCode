package com.integration.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.integration.payroll.model.User;
import com.integration.payroll.repository.UserRepository;

@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
	private UserRepository userRepository;
	
	@CrossOrigin
	@GetMapping("/user")
	public ResponseEntity<List<User>> getAllUser(@RequestParam(required = false) String name) {
		List<User> listUser = new ArrayList<User>();
		try {		
			if(name == null) {
				userRepository.findAll().forEach(listUser::add);
			}
			return new ResponseEntity<List<User>>(listUser, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		

}
