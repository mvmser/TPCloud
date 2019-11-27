package com.efrei.JPA_Rent.repository;

import java.util.Date;
import java.util.List;

import com.efrei.JPA_Rent.entity.Rent;
import org.springframework.data.repository.CrudRepository;

public interface RentRepository extends CrudRepository<Rent, Long> {
	List<Rent> findByBeginRent(Date beginRent);

}
