package com.example.carservice;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Rent implements Serializable {
	Car car;
	private Date begin;
	private Date end;

	private List<Car> cars = new ArrayList<Car>();
	
    public Rent() {
    	super();
    }
    public Rent(String _begin, String _end, List<Car> _cars) throws ParseException {
		super();
		this.begin = Rent.stringToDate(_begin);
		this.end =  Rent.stringToDate(_end);
		this.cars = _cars;
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

    static Date stringToDate(String date) throws ParseException {
    	return new SimpleDateFormat("dd/MM/yyyy").parse(date);
	}
}
