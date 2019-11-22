package com.example.carservice;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Rent implements Serializable {
	Car car;
	private Date begin;
	private Date end;

	//private List<Car> car = new ArrayList<Car>();
	
    public Rent() {
    	super();
    }
    public Rent(Date begin, Date end, Car car) {
		super();
		this.begin = begin;
		this.end = end;
		this.car = car;
	
	}
	public Car getCar() {
		return car;
	}
	public void setCar(Car car) {
		this.car = car;
	}
	public Date getBegin() {
		return begin;
	}
	public void setBegin(Date begin) {
		this.begin = begin;
	}
	public Date getEnd() {
		return end;
	}
	public void setEnd(Date end) {
		this.end = end;
	}
     
	 @Override
    public String toString() {
    	return "Car [begin =" + begin + ", end=" + end + "]" + "\n";
    }
    
}
