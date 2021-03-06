package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Enrollee;

@Repository
public interface EnrolleesRepository extends JpaRepository<Enrollee, Integer> {

	/*
	@Override
	@Query("select e from #{#entityName} e where e.deleteFlag=false")
	public List<Enrollee> findAll();

	//Look up deleted entities
	@Query("select e from #{#entityName} e where e.deleteFlag=true")
	public List<Enrollee> recycleBin(); 

	//Soft delete.
	@Query("update #{#entityName} e set e.deleteFlag=true where e.id=?1")
	@Modifying
	public void softDelete(String id); 
	
	*/
}
