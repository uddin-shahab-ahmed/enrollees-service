package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
import com.example.demo.model.Enrollee;

public interface EnroleeService {

	public List<Enrollee> getAllEnrollees();
	
	public void addEnrollees(Enrollee enrollee);
	
	public Enrollee getEnrollee(int enrolleeId) throws Exception;
	
	public Enrollee modifyEnrollee(Enrollee enrollee, @PathVariable int enrolleeId) throws Exception;
	
	public void deleteEnrollee(int enrolleeId);
	
	public Optional<Enrollee> findById(int enrolleeId);
}
