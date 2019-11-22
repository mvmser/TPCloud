package com.efrei.JPA_Rent.repository;

import java.util.List;

import com.efrei.JPA_Rent.entity.Vehicule;
import org.springframework.data.repository.CrudRepository;


public interface VehiculeRepository extends CrudRepository<Vehicule, Long>  {
	List<Vehicule> findByPlateNumber(String plateNumber);
}
