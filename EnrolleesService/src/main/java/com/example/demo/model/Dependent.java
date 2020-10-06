package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Where(clause="is_active=1")
@Table(name="dependents")
public class Dependent implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8653766376895782497L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String birthDate;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "enrolleeId")
	private Enrollee enrollee;
	
	@Column(name="is_active")
	private Boolean active;
	
	public int getId() {
		return id;
	}
	public Enrollee getEnrollee() {
		return enrollee;
	}
	public void setEnrollee(Enrollee enrollee) {
		this.enrollee = enrollee;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
		
}
