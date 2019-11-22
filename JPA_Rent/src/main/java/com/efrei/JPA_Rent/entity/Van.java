package com.efrei.JPA_Rent.entity;

import javax.persistence.Entity;

@Entity
public class Van extends Vehicule {
	private int maxWeight;

	public Van() {
	}

	public Van(String _plateNumber, int _maxWeight){
		super(_plateNumber);
		this.maxWeight = _maxWeight;
	}

	@Override
	public String toString() {
		return " Van [" + super.toString() + ", max weight = " + this.maxWeight+"] ";
	}

	public int getMaxWeight() {
		return maxWeight;
	}

	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}

	/*private double maxWeight;
	private Vehicule vehicule;


	public Van(String plateNumber, double maxWeight) {
		super(plateNumber);
		this.maxWeight = maxWeight;
	}
	public Van(String plateNumber, Rent rent, double maxWeight) {
		//super(plateNumber, rent);
		super();
		this.maxWeight = maxWeight;
	}


	public double getMaxWeight() {
		return maxWeight;
	}
	public void setMaxWeight(int maxWeight) {
		this.maxWeight = maxWeight;
	}


	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		return null;
	}*/
}
