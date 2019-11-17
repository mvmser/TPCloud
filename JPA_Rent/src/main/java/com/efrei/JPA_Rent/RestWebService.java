package com.efrei.JPA_Rent;

import com.efrei.JPA_Rent.entity.Person;
import com.efrei.JPA_Rent.entity.Rent;
import com.efrei.JPA_Rent.entity.Vehicule;
import com.efrei.JPA_Rent.repository.PersonRepository;
import com.efrei.JPA_Rent.repository.RentRepository;
import com.efrei.JPA_Rent.repository.VehiculeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestWebService {

	RentRepository rentRepository;
	PersonRepository personRepository;
	VehiculeRepository vehiculeRepository;

	@Autowired
	public RestWebService(RentRepository rentRepository) {
		super();
		this.rentRepository = rentRepository;

	}

	@GetMapping("/rents")
	public Iterable<Rent> getCities(){
		return rentRepository.findAll();
	}

	/*

	@Autowired
	public RestWebService(RentRepository rentRepository, PersonRepository personRepository, VehiculeRepository vehiculeRepository) {
		super();
		this.rentRepository = rentRepository;
		this.personRepository = personRepository;
		this.vehiculeRepository = vehiculeRepository;
	}
	
	@GetMapping("/rents")
	public Iterable<Rent> getCities(){
		return rentRepository.findAll();
	}

	@GetMapping("/persons")
	public Iterable<Person> getPersons(){
		return personRepository.findAll();
	}

	@GetMapping("/vehicules")
	public Iterable<Vehicule> getVehicules(){
		return vehiculeRepository.findAll();
	}
	*/
	
	
}
