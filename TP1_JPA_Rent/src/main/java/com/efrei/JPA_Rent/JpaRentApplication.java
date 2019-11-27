package com.efrei.JPA_Rent;

import com.efrei.JPA_Rent.entity.Car;
import com.efrei.JPA_Rent.entity.Person;
import com.efrei.JPA_Rent.entity.Rent;
import com.efrei.JPA_Rent.entity.Van;
import com.efrei.JPA_Rent.repository.PersonRepository;
import com.efrei.JPA_Rent.repository.RentRepository;
import com.efrei.JPA_Rent.repository.VehiculeRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
@SpringBootApplication
public class JpaRentApplication {

	public static void main(String[] args) {
		System.out.println("test1");
		SpringApplication.run(JpaRentApplication.class, args);
	}

}
*/
@SpringBootApplication
@EntityScan("com.efrei.JPA_Rent")
public class JpaRentApplication {
	private static final Logger log = LoggerFactory.getLogger(JpaRentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaRentApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(RentRepository rentRepository, PersonRepository personRepository, VehiculeRepository vehiculeRepository) {
		return (args) -> {

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dateStart = dateFormat.parse("2019-10-09");
			Date dateEnd = dateFormat.parse("2019-11-09");
			Date dateStart2 = dateFormat.parse("2019-02-09");
			Date dateEnd2 = dateFormat.parse("2019-04-10");

			log.info(dateStart.toString());
			log.info(dateEnd.toString());

			Person person1 = new Person("serhir");
			Person person2 = new Person("zarga");

			Car car1 = new Car("FR1234", 4);
			Car car2 = new Car("FR2234", 5);
			Van van1 = new Van("FR5564", 1200);
			Van van2 = new Van("DE7534", 1000);

			Rent rent1  = new Rent(dateStart, dateEnd, person1, car1);
			Rent rent2  = new Rent(dateStart, dateEnd, person2, car2);
			Rent rent3  = new Rent(dateStart2, dateEnd2, person2, van2);

			log.info(rent1.toString());
			log.info(rent2.toString());
			log.info(rent3.toString());

			rentRepository.save(rent1);
			rentRepository.save(rent2);
			personRepository.save(person1);
			personRepository.save(person2);
			vehiculeRepository.save(car1);
			vehiculeRepository.save(car2);
			vehiculeRepository.save(van1);
			vehiculeRepository.save(van2);

			log.info("Rents found with findAll():");
			log.info("-------------------------------");
			for (Rent rent : rentRepository.findAll()) {
				log.info(rent.toString());
			}
			log.info("");

			log.info("--------------------------------------------");
			rentRepository.findByBeginRent(dateStart).forEach(Rent -> {
				log.info(Rent.toString());
			});

		};
	}


}