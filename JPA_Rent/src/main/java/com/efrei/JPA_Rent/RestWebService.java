package com.efrei.JPA_Rent;

import com.efrei.JPA_Rent.entity.Rent;
import com.efrei.JPA_Rent.repository.RentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestWebService {

	RentRepository rentRepository;

	@Autowired
	public RestWebService(RentRepository rentRepository) {
		super();
		this.rentRepository = rentRepository;
	}
	
	@GetMapping("/rents")
	public Iterable<Rent> getCities(){
		return rentRepository.findAll();
	}
	
	
}
