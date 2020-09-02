package com.sapient.AverageCalculator.Objectmodels;

public class output {
	public String location;
	public Gender gender;
	public double calculatedaverage;
	public output(String location, Gender gender, double calculatedaverage) {
		super();
		this.location = location;
		this.gender = gender;
		this.calculatedaverage = calculatedaverage;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public double getCalculatedaverage() {
		return calculatedaverage;
	}
	public void setCalculatedaverage(double calculatedaverage) {
		this.calculatedaverage = calculatedaverage;
	}
}
