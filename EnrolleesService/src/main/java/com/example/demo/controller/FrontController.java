package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Enrollee;
import com.example.demo.repo.EnrolleesRepository;

@RestController
@RequestMapping("/enrollees")
public class FrontController {

	@Autowired
	EnrolleesRepository enrolleesRepository;
	
	@GetMapping("/getAll")
	public List<Enrollee> getAllEnrollees() {
		System.out.println("/getAll  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return enrolleesRepository.findAll();
		
	}
	
	@PostMapping("/add")
	public void addEnrollees(@RequestBody Enrollee enrollee) {
		System.out.println("/add >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		enrolleesRepository.save(enrollee);
	}
	
	@GetMapping("/get/{enrolleeId}")
	public Enrollee getEnrollee(@PathVariable int enrolleeId) throws Exception {
		System.out.println("/get >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Optional<Enrollee> enrollee = enrolleesRepository.findById(enrolleeId);	
		if(!enrollee.isPresent()) {
			// throw exception
			throw new Exception("Enrollee not found >>>>>>>>>");
		} else
		{
			return enrollee.get();
		}
	}
	
	@PutMapping("/modify/{enrolleeId}")
	public Enrollee modifyEnrollee(@RequestBody Enrollee enrollee, @PathVariable int enrolleeId) throws Exception {
		System.out.println("/modify >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Optional<Enrollee> e = enrolleesRepository.findById(enrolleeId);
		if(e.isPresent()) {
			enrollee.setEnrolleeId(enrolleeId);
			enrolleesRepository.save(enrollee);
			return enrolleesRepository.findById(enrolleeId).get();
		} else {
			throw new Exception("Enrollee not found >>>>>>>>>");
		}
	}
	
	@DeleteMapping("/delete/{enrolleeId}")
	public void deleteEnrollee(@PathVariable int enrolleeId) {
		System.out.println("/delete >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		enrolleesRepository.deleteById(enrolleeId);
	}	
	
}
