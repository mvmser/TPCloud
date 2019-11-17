package com.example.client;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

import com.example.carservice.Car;



public class CarRentalClient {
	
	private static final Logger log = LoggerFactory.getLogger(CarRentalClient.class);
	
    public static void main(String[] args) {

        RestTemplate restTemplate = new RestTemplate();

        /**
         * TODO: make requests to your server http://localhost:8080
         * restTemplate.postForObject(..., ..., ...);
         * restTemplate.getForObject(..., ...);
         * */
        
		
		
		HttpEntity<Car> request = new HttpEntity<>(new Car("44QQ66", "Peugeot", 12));
		restTemplate.postForObject("http://localhost:8080/cars", request, Car.class);
		restTemplate.patchForObject("http://localhost:8080/cars", request, Car.class);
		
        @SuppressWarnings("unchecked")
		List<Car> cars = restTemplate.getForObject("http://localhost:8080/cars", List.class);
        log.info(cars.toString());
    }
}
