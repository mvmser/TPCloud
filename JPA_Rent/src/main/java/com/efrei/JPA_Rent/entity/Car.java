package com.efrei.JPA_Rent.entity;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicule {
	private int numberOfSeats;

	public Car(String _plateNumber, int _numberOfSeats) {
		super(_plateNumber);
		this.numberOfSeats = _numberOfSeats;
	}
	/*
	private int numberOfSeats;


	public Car(String plateNumber, int numberOfSeats) {
		super(plateNumber);

		this.numberOfSeats = numberOfSeats;
	}

	public Car(String plateNumber, Rent rent, int numberOfSeats) {
		//super(plateNumber, rent);
		super();
		this.numberOfSeats = numberOfSeats;
	}

	public int getNumberOfSeats() {
		return numberOfSeats;
	}
	public void setNumberOfSeatst(int numberOfSeats) {
		this.numberOfSeats = numberOfSeats;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return null;
	}
	*/
}
