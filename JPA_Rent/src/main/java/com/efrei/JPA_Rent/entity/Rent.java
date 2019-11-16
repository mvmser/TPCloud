package com.efrei.JPA_Rent.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.lang.NonNull;

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

	@ManyToOne(cascade=CascadeType.ALL)
	private Person person;

	@OneToMany(mappedBy = "rent", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Vehicule> vehicules = new ArrayList<>();

	public Rent() { }

	public Rent (Date _beginRent, Date _endRent, Person _person) {
		this.beginRent = _beginRent;
		this.endRent = _endRent;
		this.person = _person;
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
