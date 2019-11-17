package com.example.carservice;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.client.CarRentalClient;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@RestController
public class CarRentalService {
	private static final Logger log = LoggerFactory.getLogger(CarRentalService.class);
    /**
     * TODO: create list of cars
    */
	private List<Car> cars = new ArrayList<Car>();

    public CarRentalService() {
    	cars.add(new Car("11AA22", "Ferrari", 1000));
		cars.add(new Car("33BB44", "Porshe", 2222));
		cars.add(new Car("26HY95", "Peugeot", 5283));
		cars.add(new Car("68ZU21", "Mercedes", 9876));
    }

    /** TEST */
    @GetMapping("/example")  
    public String example() {  
        return "Hello Actuator !! ";  
    } 
    
    /** Display cars */
    @RequestMapping(value = "/cars", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public List<Car> getCars() {
    	log.info(cars.toString());
    	return cars;
    }
    
    
    /** Add car in List */
    @RequestMapping(value = "/cars", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    public void addCar(@RequestBody Car car) {
    	System.out.println(car);
		cars.add(car);
		log.info(car.toString());
		
    }

    
    /** Get feature of car */
    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Car> getFeaturesCar(@PathVariable String plateNumber) {
    	System.out.println(plateNumber);

    	Car car = null;
    	for (Car currentCar : cars) {
    	    if (currentCar.getPlateNumber().equals(plateNumber)) {
    	    	car = currentCar;
    	    	break;
    	    }
    	}    
		return  new ResponseEntity<Car>(car, HttpStatus.OK);
    }
    
    
    /** Rent car 
     * 
     * A MODIFIER
     * 
     * */ 
    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
    @ResponseBody
    @JsonDeserialize
    public void rent(@PathVariable("plateNumber") String plateNumber, 
    		@RequestParam(value="rent", required = true) boolean rent, 
    		@RequestBody Date begin) throws Exception {
    	Date end = new Date(System.currentTimeMillis());
    	
    	System.out.println(plateNumber);
    	
    	System.out.println("\n\n\n\n\n\n\n\n\n\nDATE ICIII" + begin + System.currentTimeMillis());
    	Car car = null;
    	
    	for (Car currentCar : cars) {
    	    if (currentCar.getPlateNumber().equals(plateNumber)) {
    	    	car = currentCar;
    	    	car.addRent(new Rent(end, end, car));
    	    	car.setRented(true);
    	    	//rent = true;
    	    	
    	    	System.out.println("The car " + plateNumber + " is rented now");
    	    	break;
    	    }
    	} 
    }
    
    public class CustomJsonDateDeserializer extends JsonDeserializer<Date> {
        public Date deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            String date = jsonParser.getText();
            try {
                return format.parse(date);
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
    }

    
    /** Rent and get Back*
     * 
     *  A MODIFIER
     *  
     *  
    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK) 
    public void rentAndGetBack(@PathVariable("plateNumber") String plateNumber, 
    	@RequestParam(value="rent", required = true)boolean rent,
    	@RequestBody Dates dates) throws Exception{
    	Car car = null;
    	for (Car currentCar : cars) {
    	    if (currentCar.getPlateNumber().equals(plateNumber)) {
    	    	car = currentCar;
    	    	break;
    	    }
    	}  
    	if (car.isRented() == false)
    	{
    		Rent carRent = null;
    		car = carRent.getCar();
    		dates.toString();
    	}
    	
    }*/
    
    
    /** Get back car
     * 
     *  A MODIFIER
     *  
     *  
    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.DELETE) 
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Car> getBack(@PathVariable("plateNumber") String plateNumber){
		return null;
    	
    }*/
    
    
    /** Delete car */
    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.DELETE)
    @ResponseBody
    public ResponseEntity<Car> deleteCar(@PathVariable String plateNumber) {
    	System.out.println(plateNumber);
    	Car car = null;

    	for (Car currentCar : cars) {
    	    if (currentCar.getPlateNumber().equals(plateNumber)) {
    	    	car = currentCar;
    	    	cars.remove(car);
    	    	break;
    	    }
    	}    
    	return  new ResponseEntity<Car>(car, HttpStatus.OK);
    }
    
    
   
    
    
}
