package com.efrei.JPA_Rent.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Van extends Vehicule {
	private int maxWeight;

	public Van(String _plateNumber, int _maxWeight){
		super(_plateNumber);
		this.maxWeight = _maxWeight;
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
