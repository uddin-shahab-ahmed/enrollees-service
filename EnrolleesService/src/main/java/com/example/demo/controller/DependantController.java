package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Dependent;
import com.example.demo.model.Enrollee;
import com.example.demo.repo.DependentsRepository;

@RestController
@RequestMapping("/dependents")
public class DependantController {

	@Autowired
	DependentsRepository dependentRepository;

	@GetMapping("/getAll")
	public List<Dependent> getAllEnrollees() {
		System.out.println("/getAll dependents >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return dependentRepository.findAll();
	}
	
	@GetMapping("/get/{enrolleeId}")
	public Dependent getEnrollee(@PathVariable int enrolleeId) throws Exception {
		System.out.println("/get dependents >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Optional<Dependent> enrollee = dependentRepository.findById(enrolleeId);	
		if(!enrollee.isPresent()) {
			// throw exception
			throw new Exception("Enrollee not found >>>>>>>>>");
		} else
		{
			return enrollee.get();
		}
	}

	@PostMapping("/add/{enrolleeId}")
	public void addEnrollees(@RequestBody Dependent dependent, @PathVariable int enrolleeId) {
		Enrollee enrollee = new Enrollee();
		enrollee.setEnrolleeId(enrolleeId);
		dependent.setEnrollee(enrollee);
		System.out.println("/add dependents >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		dependentRepository.save(dependent);
	}

	@PutMapping("/modify/{enrolleeId}")
	public Dependent modifyDependant(@RequestBody Dependent dependent, @PathVariable int enrolleeId) throws Exception {
		System.out.println("/modify dependents >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");

		// Need to write method for finding dependent by name and enrolle id in
		// repository
		Optional<Dependent> e = dependentRepository.findById(enrolleeId);
		if (e.isPresent()) {
			dependent.setId(enrolleeId);
			dependent.setEnrollee(e.get().getEnrollee());
			dependentRepository.save(dependent);
			return dependentRepository.findById(enrolleeId).get();
		} else {
			throw new Exception("Dependant not found >>>>>>>>>");
		}
	}

	@DeleteMapping("/delete/{dependentId}")
	public void deleteEnrollee(@PathVariable int dependantId) {
		System.out.println("/delete dependents >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		dependentRepository.deleteById(dependantId);
	}

}
