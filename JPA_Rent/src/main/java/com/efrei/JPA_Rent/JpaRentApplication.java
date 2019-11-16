package com.efrei.JPA_Rent;

import com.efrei.JPA_Rent.entity.Person;
import com.efrei.JPA_Rent.entity.Rent;
import com.efrei.JPA_Rent.repository.RentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
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
public class JpaRentApplication {
	private static final Logger log = LoggerFactory.getLogger(JpaRentApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JpaRentApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(RentRepository repository) {
		return (args) -> {

			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date dateStart = dateFormat.parse("2019-10-09");
			Date dateEnd = dateFormat.parse("2019-11-09");

			log.info(dateStart.toString());
			log.info(dateEnd.toString());

			Person person1 = new Person("person1");
			Rent rent1  = new Rent(dateStart, dateEnd, person1);
			log.info(rent1.toString());

			repository.save(rent1);

			log.info("Rents found with findAll():");
			log.info("-------------------------------");
			for (Rent rent : repository.findAll()) {
				log.info(rent.toString());
			}
			log.info("");

			log.info("--------------------------------------------");
			repository.findByBeginRent(dateStart).forEach(Rent -> {
				log.info(Rent.toString());
			});

		};
	}
}