package com.efrei.JPA_Rent.repository;

import java.util.List;

import com.efrei.JPA_Rent.entity.Person;
import org.springframework.data.repository.CrudRepository;


public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findByName(String name);
}
