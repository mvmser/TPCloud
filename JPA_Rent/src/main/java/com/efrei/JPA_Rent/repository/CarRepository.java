package com.efrei.JPA_Rent.repository;

import java.util.List;

import com.efrei.JPA_Rent.entity.Car;
import org.springframework.data.repository.CrudRepository;

public interface CarRepository extends CrudRepository<Car, Long> {
	List<Car> findByNumberOfSeats(int numberOfSeats);
}
