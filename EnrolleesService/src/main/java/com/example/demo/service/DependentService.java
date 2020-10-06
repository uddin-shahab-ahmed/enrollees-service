package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.Dependent;

public interface DependentService {

	public Dependent getEnrollee(int enrolleeId) throws Exception;
	
	public List<Dependent> getAllEnrollees();
	
	public void addEnrollees(Dependent dependent,int enrolleeId);
	
	public Dependent modifyDependant(Dependent dependent, int enrolleeId) throws Exception;
	
	public void deleteEnrollee(int dependantId);
	
	public Optional<Dependent> findById(int enrolleeId);
}
