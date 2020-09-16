package com.example.demo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="enrollees")
public class Enrollee implements Serializable {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int enrolleeId;
	@Column(nullable=false)
	private String enrolleeName;
	@Column(nullable=false)
	private boolean activationStatus;
	@Column(nullable=false)
	private String birthDate;
	@Column
	private String phoneNumber;
	
	@OneToMany(mappedBy = "enrollee", fetch= FetchType.EAGER)
	private List<Dependent> dependents;
	
	public List<Dependent> getDependents() {
		return dependents;
	}
	public void setDependents(List<Dependent> dependents) {
		this.dependents = dependents;
	}
	
	public String getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public boolean isActivationStatus() {
		return activationStatus;
	}
	public void setActivationStatus(boolean activationStatus) {
		this.activationStatus = activationStatus;
	}
	public int getEnrolleeId() {
		return enrolleeId;
	}
	public void setEnrolleeId(int enrolleeId) {
		this.enrolleeId = enrolleeId;
	}
	public String getEnrolleeName() {
		return enrolleeName;
	}
	public void setEnrolleeName(String enrolleeName) {
		this.enrolleeName = enrolleeName;
	}
}
