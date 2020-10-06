package com.example.demo.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Enrollee;
import com.example.demo.repo.EnrolleesRepository;
import com.example.demo.service.EnroleeService;

@Service
public class EnroleeServiceImpl implements EnroleeService {

	private static final Logger LOGGER = LogManager.getLogger(EnroleeServiceImpl.class);

	@Autowired
	EnrolleesRepository enrolleesRepository;

	@Override
	public List<Enrollee> getAllEnrollees() {
		LOGGER.info("getAllEnrollees() of EnroleeServiceImpl begins");
		List<Enrollee> enrolleeList = enrolleesRepository.findAll();
		LOGGER.info("getAllEnrollees() of EnroleeServiceImpl ends");
		return enrolleeList;
	}

	@Override
	public void addEnrollees(Enrollee enrollee) {
		LOGGER.info("addEnrollees() of EnroleeServiceImpl begins");
		enrolleesRepository.save(enrollee);
		LOGGER.info("addEnrollees() of EnroleeServiceImpl ends");
	}

	@Override
	public Enrollee getEnrollee(int enrolleeId) throws Exception {
		LOGGER.info("getEnrollee() of EnroleeServiceImpl begins");
		Optional<Enrollee> enrollee = enrolleesRepository.findById(enrolleeId);
		if (!enrollee.isPresent()) {
			// throw exception
			throw new Exception("Enrollee not found >>>>>>>>>");
		} else {
			return enrollee.get();
		}
//		LOGGER.info("getEnrollee() of EnroleeServiceImpl ends");
	}

	@Override
	public Enrollee modifyEnrollee(Enrollee enrollee, int enrolleeId) throws Exception {
		LOGGER.info("modifyEnrollee() of EnroleeServiceImpl begins");
		Optional<Enrollee> e = enrolleesRepository.findById(enrolleeId);
		if (e.isPresent()) {
			enrollee.setEnrolleeId(enrolleeId);
			enrolleesRepository.save(enrollee);
			return enrolleesRepository.findById(enrolleeId).get();
		} else {
			throw new Exception("Enrollee not found >>>>>>>>>");
		}
//		LOGGER.info("modifyEnrollee() of EnroleeServiceImpl ends");
	}

	@Override
	public void deleteEnrollee(int enrolleeId) {
		LOGGER.info("deleteEnrollee() of EnroleeServiceImpl begins");
		enrolleesRepository.deleteById(enrolleeId);
		LOGGER.info("deleteEnrollee() of EnroleeServiceImpl ends");
	}

	@Override
	public Optional<Enrollee> findById(int enrolleeId) {
		return enrolleesRepository.findById(enrolleeId);
	}

}
