package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.example.demo.service.EnroleeService;

@RestController
@RequestMapping("/enrollees")
public class FrontController {

	private static final Logger LOGGER = LogManager.getLogger(FrontController.class);

	@Autowired
	EnroleeService enroleeService;

	@GetMapping("/getAll")
	public List<Enrollee> getAllEnrollees() {
		LOGGER.info("getAllEnrollees() of FrontController begins");
		return enroleeService.getAllEnrollees();
//		LOGGER.info("getAllEnrollees() of FrontController ends");

	}

	@PostMapping("/add")
	public void addEnrollees(@RequestBody Enrollee enrollee) {
		LOGGER.info("addEnrollees() of FrontController begins");
		enroleeService.addEnrollees(enrollee);
		LOGGER.info("addEnrollees() of FrontController ends");
	}

	@GetMapping("/get/{enrolleeId}")
	public Enrollee getEnrollee(@PathVariable int enrolleeId) throws Exception {
		LOGGER.info("getEnrollee() of FrontController begins");
		Optional<Enrollee> enrollee = enroleeService.findById(enrolleeId);
		if (!enrollee.isPresent()) {
			// throw exception
			throw new Exception("Enrollee not found >>>>>>>>>");
		} else {
			return enrollee.get();
		}
//		LOGGER.info("getEnrollee() of FrontController ends");
	}

	@PutMapping("/modify/{enrolleeId}")
	public Enrollee modifyEnrollee(@RequestBody Enrollee enrollee, @PathVariable int enrolleeId) throws Exception {
		LOGGER.info("modifyEnrollee() of FrontController begins");
		Optional<Enrollee> e = enroleeService.findById(enrolleeId);
		if (e.isPresent()) {
			enrollee.setEnrolleeId(enrolleeId);
			enroleeService.addEnrollees(enrollee);
			return enroleeService.findById(enrolleeId).get();
		} else {
			throw new Exception("Enrollee not found >>>>>>>>>");
		}
//		LOGGER.info("modifyEnrollee() of FrontController ends");
	}

	@DeleteMapping("/delete/{enrolleeId}")
	public void deleteEnrollee(@PathVariable int enrolleeId) {
		LOGGER.info("deleteEnrollee() of FrontController begins");
		enroleeService.deleteEnrollee(enrolleeId);
		LOGGER.info("deleteEnrollee() of FrontController ends");
	}

}
