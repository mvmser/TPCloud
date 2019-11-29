package com.example.carservice;
import com.example.carservice.Dates;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
@RestController
public class CarRentalService {
	private static final Logger log = LoggerFactory.getLogger(CarRentalService.class);

	private List<Car> cars = new ArrayList<Car>();

    public CarRentalService() {
    	/* Create some cars*/
    	cars.add(new Car("11AA22", "Ferrari", 600));
		cars.add(new Car("33BB44", "Porshe", 700));
		cars.add(new Car("26HY95", "Peugeot", 50));
		cars.add(new Car("68ZU21", "Mercedes", 70));
		cars.add(new Car("96HF45", "Audi", 60));
		cars.add(new Car("96GF34", "BMW", 75));
		cars.add(new Car("28HQ78", "Volkwagen", 55));
		cars.add(new Car("04GQ34", "Fiat", 30));
		cars.add(new Car("48PB34", "Tesla", 100));
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
    
	/** Rent a car */
    @RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.POST)
    public void rent(@PathVariable("plateNumber") String plateNumber, @RequestParam(value="rent") boolean rent, @RequestBody Dates dates) throws Exception {
    	//Date end = new Date(System.currentTimeMillis());
    	//System.out.println(plateNumber);
		System.out.println(dates);
    	
    	//System.out.println("\n\n\n\n\n\n\n\n\n\nDATE ICIII" + begin + end);
    	//Car car = null; comparer plate number for

    	/*
    	for (Car currentCar : cars) {
    	    if (currentCar.getPlateNumber().equals(plateNumber)) {
    	    	car = currentCar;
    	    	car.addRent(new Rent(end, end, car));
    	    	car.setRented(true);
    	    	rent = true;
    	    	
    	    	System.out.println("The car " + plateNumber + " is rented now");
    	    	break;
    	    }
    	}
    }*/

    }


	/** Rent and get Back*
	 *
	 *  A MODIFIER
	 *

	@RequestMapping(value = "/cars/{plateNumber}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	public void rentAndGetBack(@PathVariable("plateNumber") String plateNumber,
							   @RequestParam(value="rent", required = true) boolean rent,
							   @RequestBody Date dates) throws Exception{

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
    		//dates.toString();
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

