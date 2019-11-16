package com.efrei.JPA_Rent.entity;

import ch.qos.logback.classic.net.SMTPAppender;
import com.sun.javafx.beans.IDProperty;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "vehicule")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Vehicule {
	@Id private String plateNumber;

	@ManyToOne private Rent rent;

	public Vehicule() { }

	public Vehicule(String _plateNumber) { this.plateNumber = _plateNumber;}

	/*
	//@OneToMany(targetEntity = Rent.class, mappedBy = "vehicule")
	private List<Person> persons = new ArrayList<Person>();

	private List<Car> car = new ArrayList<Car>();
	private List<Van> van = new ArrayList<Van>();

	@ManyToOne
	private List<Rent> rents = new ArrayList();


	@Id
	private long id;

	private String plateNumber;

	public Vehicule(String plateNumber, Rent rent) {
		super();
	}
	public Vehicule(String plateNumber) {
		super();
	}


	public String getPlateNumber() {
		return plateNumber;
	}
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	
	public List<Person> getPersons() {
		return persons;
	}

	public void setPersons(List<Person> persons) {
		this.persons = persons;
	}
	
	public List<Car> getCar() {
		return car;
	}

	public void setCars(List<Car> car) {
		this.car = car;
	}
	


	@Override
	public String toString() {
		return "Vehicule [persons=" + persons + ", car=" + car + ", van=" + van + ", plateNumber=" + plateNumber + "]";
	}

	public String carString() {
		// TODO Auto-generated method stub
		return null;
	}
	*/
}
