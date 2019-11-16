package com.efrei.JPA_Rent.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.efrei.JPA_Rent.entity.Vehicule;


public interface VehiculeRepository extends CrudRepository<Vehicule, Long>  {
	List<Vehicule> findByPlateNumber(String plateNumber);
}
