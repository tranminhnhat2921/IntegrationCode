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

import com.integration.hr.model.JobHistory;
import com.integration.hr.repository.JobHistoryRepository;

@RestController
@RequestMapping("/api")
public class JobHistoryController {

	@Autowired
	JobHistoryRepository jobHistoryRepository;

	@CrossOrigin
	@GetMapping("/jobhistory")
	public ResponseEntity<List<JobHistory>> getAllJobHistory(@RequestParam(required = false) String emId) {
		List<JobHistory> list = new ArrayList<JobHistory>();
		try {
			if (emId == null)
				jobHistoryRepository.findAll().forEach(list::add);
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@GetMapping("/jobhistory/{id}")
	public ResponseEntity<JobHistory> getJobHistoryById(@PathVariable("id") BigDecimal id) {
		try {
			Optional<JobHistory> jobHistory = jobHistoryRepository.findById(id);
			if (jobHistory.isPresent()) {
				return new ResponseEntity<>(jobHistory.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@PostMapping("/jobhistory")
	public ResponseEntity<JobHistory> createJobHistory(@RequestBody JobHistory jobHistory) {
		try {
			JobHistory _jobHistory = jobHistoryRepository.save(
					new JobHistory(jobHistory.getEmployee_ID(), jobHistory.getDepartment(), jobHistory.getDivision(),
							jobHistory.getStart_Date(), jobHistory.getEnd_Date(), jobHistory.getJob_Title(),
							jobHistory.getSupervisor(), jobHistory.getJob_Category(), jobHistory.getLocation(),
							jobHistory.getDepartmen_Code(), jobHistory.getSalary_Type(), jobHistory.getPay_Period(),
							jobHistory.getHours_per_Week(), jobHistory.isHazardous_Training()));
			return new ResponseEntity<>(_jobHistory, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@CrossOrigin
	@PutMapping("/jobhistory/{id}")
	public ResponseEntity<JobHistory> updateJobHistory(@PathVariable("id") BigDecimal id,
			@RequestBody JobHistory jobHistory) {
		Optional<JobHistory> jobHistoryData = jobHistoryRepository.findById(id);
		if (jobHistoryData.isPresent()) {
			JobHistory _jobHistory = jobHistoryData.get();
			_jobHistory.setEmployee_ID(jobHistory.getEmployee_ID());
			_jobHistory.setDepartment(jobHistory.getDepartment());
			_jobHistory.setDivision(jobHistory.getDivision());
			_jobHistory.setStart_Date(jobHistory.getStart_Date());
			_jobHistory.setEnd_Date(jobHistory.getEnd_Date());
			_jobHistory.setJob_Title(jobHistory.getJob_Title());
			_jobHistory.setSupervisor(jobHistory.getSupervisor());
			_jobHistory.setJob_Category(jobHistory.getJob_Category());
			_jobHistory.setLocation(jobHistory.getLocation());
			_jobHistory.setDepartmen_Code(jobHistory.getDepartmen_Code());
			_jobHistory.setSalary_Type(jobHistory.getSalary_Type());
			_jobHistory.setPay_Period(jobHistory.getPay_Period());
			_jobHistory.setHours_per_Week(jobHistory.getHours_per_Week());
			_jobHistory.setHazardous_Training(jobHistory.isHazardous_Training());
			return new ResponseEntity<>(jobHistoryRepository.save(_jobHistory), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@CrossOrigin
	@DeleteMapping("/jobhistory/{id}")
	public ResponseEntity<HttpStatus> deleteJobHistory(@PathVariable("id") BigDecimal id) {
		try {
			jobHistoryRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
