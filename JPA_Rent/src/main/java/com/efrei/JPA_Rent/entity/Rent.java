package com.efrei.JPA_Rent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "rent")
public class Rent {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@CreatedDate @Temporal(TemporalType.TIMESTAMP)
	private Date beginRent;
	@LastModifiedDate @Temporal(TemporalType.TIMESTAMP)
	private Date endRent;

	@ManyToOne(cascade=CascadeType.ALL) @JsonIgnore
	private Person person;

	@OneToMany(mappedBy = "rent", cascade=CascadeType.ALL, fetch = FetchType.EAGER) @JsonIgnore
	private List<Vehicule> vehicules = new ArrayList<>();

	//private List<Car> cars = new ArrayList<Car>();
	//private List<Van> vans = new ArrayList<Van>();

	public Rent() { }

	public Rent (Date _beginRent, Date _endRent, Person _person) {
		this.beginRent = _beginRent;
		this.endRent = _endRent;
		this.person = _person;
	}

	public Rent (Date _beginRent, Date _endRent, Person _person, Car car) {
		this.beginRent = _beginRent;
		this.endRent = _endRent;
		this.person = _person;
		this.vehicules.add(car);
		car.setRent(this);
	}

	public Rent (Date _beginRent, Date _endRent, Person _person, Van van) {
		this.beginRent = _beginRent;
		this.endRent = _endRent;
		this.person = _person;
		this.vehicules.add(van);
		//van.setRent(this);
	}

	@Override
	public String toString() {
		return "Rent [begin = " + this.beginRent + ", end = " + this.endRent + ", person =" + this.person + ", vehicule(s) = " + this.vehicules + "]";
	}

	public void addCar(Car car){
		//car.setRent(this);
		vehicules.add(car);
	}

	public void addVan(Van van){
		//van.setRent(this);
		vehicules.add(van);
	}

	public void rmCar(Car car){
		vehicules.remove(car);
	}

	public void rmVan(Van van){
		vehicules.remove(van);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getBeginRent() {
		return beginRent;
	}

	public void setBeginRent(Date beginRent) {
		this.beginRent = beginRent;
	}

	public Date getEndRent() {
		return endRent;
	}

	public void setEndRent(Date endRent) {
		this.endRent = endRent;
	}

	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	public List<Vehicule> getVehicules() {
		return vehicules;
	}

	public void setVehicules(List<Vehicule> vehicules) {
		this.vehicules = vehicules;
	}

	/*
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@CreatedDate @Temporal(TemporalType.TIMESTAMP)
	private Date beginRent;
	@LastModifiedDate @Temporal(TemporalType.TIMESTAMP)
	private Date endRent;

	@ManyToOne
	private Person person; 
	
	//@OneToMany(targetEntity = Vehicule.class, mappedBy = "rent", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
	//@OneToMany(mappedBy = "rent")
	@OneToMany(mappedBy="rent", cascade=CascadeType.ALL, fetch = FetchType.EAGER) @JsonIgnore
	private List<Vehicule> vehicules = new ArrayList<>();

	public List<Vehicule> getVehicule() {
		return vehicules;
	}
	
	protected Rent() {

	}
	public Rent (Date beginRent, Date endRent, Person person) {
		this.beginRent = beginRent;
		this.endRent = endRent; 
		this.person = person;
	}
	*/
	
}
