package com.efrei.JPA_Rent.repository;

import java.util.List;

import com.efrei.JPA_Rent.entity.Van;
import org.springframework.data.repository.CrudRepository;

public interface VanRepository extends CrudRepository<Van, Long> {
	List<Van> findByMaxWeight(int maxWeight);
}
