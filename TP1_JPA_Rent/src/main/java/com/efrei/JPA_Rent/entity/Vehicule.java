package com.efrei.JPA_Rent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "VEHICULE")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "type")
@JsonSubTypes({
		@JsonSubTypes.Type(value = Car.class, name = "car"),
		@JsonSubTypes.Type(value = Van.class, name = "van")
})
public abstract class Vehicule {
	@Id @Column(unique = true, name = "PLATENUMBER", nullable = false) private String plateNumber;

	//@ManyToOne @JsonIgnore private List<Rent> rents = new ArrayList<>();

    @OneToMany(targetEntity = Rent.class, mappedBy = "vehicule", cascade=CascadeType.ALL, fetch = FetchType.EAGER) @JsonIgnore @Column
	private List<Rent> rents = new ArrayList<>();

	//private Rent rent;

	public Vehicule() { }

	public Vehicule(String _plateNumber) { this.plateNumber = _plateNumber;}

	@Override
	public String toString() {
		return "plateNumber = " + plateNumber;
	}

	public String getPlateNumber() {
		return plateNumber;
	}

	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}

	public List<Rent> getRents() {
		return rents;
	}

	public void addRent(Rent rent){
		this.rents.add(rent);
	}

	public void setRents(List<Rent> rents) {
		this.rents = rents;
	}

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
