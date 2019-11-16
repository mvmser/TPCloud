package com.efrei.JPA_Rent.repository;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.efrei.JPA_Rent.entity.Person;


public interface PersonRepository extends CrudRepository<Person, Long> {
	List<Person> findByName(String name);
}
