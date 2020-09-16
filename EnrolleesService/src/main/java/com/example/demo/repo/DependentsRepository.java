package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Dependent;

@Repository
public interface DependentsRepository  extends JpaRepository<Dependent, Integer>{

}
