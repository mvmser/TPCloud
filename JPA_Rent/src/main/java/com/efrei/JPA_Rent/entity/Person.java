package com.efrei.JPA_Rent.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import org.springframework.lang.NonNull;

@Entity
@Table(name = "person")
public class Person {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NonNull private String name;

	@OneToMany(mappedBy = "person", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Rent> rents = new ArrayList();

	public Person() { }
	public Person(String _name) {
		this.name = _name;
	}



	/*
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NonNull
	private String name;

	@OneToMany(mappedBy="person", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Rent> rents = new ArrayList();

	
	public List<Rent> getRents() {
		return rents;
	}
	
	protected Person() {
	}
	
	public Person(String name) {
		this.name = name;
	}
	
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	*/
}