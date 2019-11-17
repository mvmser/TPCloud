package com.example.carservice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Car implements Serializable {

	
	private String plateNumber;
	private String brand;
	private int price;
	private boolean isRented;

	
	private List<Rent> rents = new ArrayList<Rent>();
	
	
    public Car() {
    	super();
    }
    public Car(String plateNumber, String brand, int price) {
		super();
		this.plateNumber = plateNumber;
		this.brand = brand;
		this.price = price;
		isRented = false;
	}

    public String getPlateNumber() {
    	return plateNumber;
    }

    public void setPlateNumber(String plateNumber) {
    	this.plateNumber = plateNumber;
    }

    public String getBrand() {
    	return brand;
    }

    public void setBrand(String brand) {
    	this.brand = brand;
    }

    public int getPrice() {
    	return price;
    }

    public void setPrice(int price) {
    	this.price = price;
    }
    public void setRented(boolean isRented) {
    	this.isRented = isRented;
    }
    public boolean isRented() {
        return isRented;
    }

    boolean rentCar() {
    	if(isRented = true)
    		return true;
        return false;
    }

    boolean getBackCar() {
        
        return false;
    }

    public List<Rent> getRents() {
		return rents;
	}
	public void addRent(Rent rent) {
		rents.add(rent);
	}

    @Override
    public String toString() {
    	return "Car [plateNumber=" + plateNumber + ", brand=" + brand + ", price=" + price + "]" + "\n";
    }
}
