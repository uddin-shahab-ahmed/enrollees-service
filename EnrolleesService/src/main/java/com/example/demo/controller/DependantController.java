package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.EnrolleesServiceApplication;
import com.example.demo.model.Dependent;
import com.example.demo.service.DependentService;

@RestController
@RequestMapping("/dependents")
public class DependantController {


	  private static final Logger LOGGER = LogManager.getLogger(DependantController.class); 
	@Autowired
	DependentService dependentService;

	@GetMapping("/getAll")
	public List<Dependent> getAllEnrollees() {
		LOGGER.info("getAllEnrollees() of DependantController begins");
		return dependentService.getAllEnrollees();
	}
	
	@GetMapping("/get/{enrolleeId}")
	public Dependent getEnrollee(@PathVariable int enrolleeId) throws Exception {
		LOGGER.info("getEnrollee() of DependantController begins");
		Optional<Dependent> enrollee = dependentService.findById(enrolleeId);	
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
		LOGGER.info("addEnrollees() of DependantController begins");
		dependentService.addEnrollees(dependent,enrolleeId);
	}

	@PutMapping("/modify/{enrolleeId}")
	public Dependent modifyDependant(@RequestBody Dependent dependent, @PathVariable int enrolleeId) throws Exception {
		LOGGER.info("modifyDependant() of DependantController begins");
		// Need to write method for finding dependent by name and enrolle id in
		// repository
		Optional<Dependent> e = dependentService.findById(enrolleeId);
		if (e.isPresent()) {
			dependentService.modifyDependant(dependent,enrolleeId);
			return dependentService.findById(enrolleeId).get();
		} else {
			throw new Exception("Dependant not found >>>>>>>>>");
		}
	}

	@DeleteMapping("/delete/{dependentId}")
	public void deleteEnrollee(@PathVariable int dependantId) {
		LOGGER.info("deleteEnrollee() of DependantController begins");
		dependentService.deleteEnrollee(dependantId);
	}

}
