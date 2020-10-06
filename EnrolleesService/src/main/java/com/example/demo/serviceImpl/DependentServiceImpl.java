package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.FrontController;
import com.example.demo.model.Dependent;
import com.example.demo.model.Enrollee;
import com.example.demo.repo.DependentsRepository;
import com.example.demo.service.DependentService;

@Service
public class DependentServiceImpl implements DependentService{
	
	 private static final Logger LOGGER = LogManager.getLogger(DependentServiceImpl.class); 
	 
	@Autowired
	DependentsRepository dependentRepository;

	@Override
	public Dependent getEnrollee(int enrolleeId) throws Exception {
		LOGGER.info("getEnrollee() of DependentServiceImpl begins");
		Optional<Dependent> enrollee = dependentRepository.findById(enrolleeId);	
		if(!enrollee.isPresent()) {
			// throw exception
			throw new Exception("Enrollee not found >>>>>>>>>");
		} else
		{
			return enrollee.get();
		}
//		LOGGER.info("getEnrollee() of DependentServiceImpl ends");
	}

	@Override
	public List<Dependent> getAllEnrollees() {
		LOGGER.info("getAllEnrollees() of DependentServiceImpl begins");
		return dependentRepository.findAll();
//		LOGGER.info("getAllEnrollees() of DependentServiceImpl ends");
	}

	@Override
	public void addEnrollees(Dependent dependent, int enrolleeId) {
		//verify the logic
		LOGGER.info("addEnrollees() of DependentServiceImpl begins");
		Enrollee enrollee = new Enrollee();
		enrollee.setEnrolleeId(enrolleeId);
		dependent.setEnrollee(enrollee);
		dependentRepository.save(dependent);
		LOGGER.info("addEnrollees() of DependentServiceImpl ends");
	}

	@Override
	public Dependent modifyDependant(Dependent dependent, int enrolleeId) throws Exception {
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

	@Override
	public void deleteEnrollee(int dependantId) {
		LOGGER.info("deleteEnrollee() of DependentServiceImpl begins");
		dependentRepository.deleteById(dependantId);
		LOGGER.info("deleteEnrollee() of DependentServiceImpl ends");
	}

	@Override
	public Optional<Dependent> findById(int enrolleeId) {
		return dependentRepository.findById(enrolleeId);
	}

}
