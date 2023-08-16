package com.springboot.application.model;

public class Jet extends Aircraft {
    // Unique to Jet - specific fuel
    private String fuel;

    // Default Constructor
    public Jet() {}

    // Default Constructor
    public Jet(String tailNum, int wheelsNum, int length, String fuel) {
        super(tailNum, wheelsNum, length);
        this.fuel = fuel;
    }

    // Setters and Getters
    public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getFuel() {
		return fuel;
	}

    // Method override
    @Override
    public void printDetails() {
        System.out.println("Tail Number: " + getTailNumber());
        System.out.println("Number of Wheels: " + getNumberOfWheels());
        System.out.println("Length: " + getLength());
        System.out.println("Name of Fuel: " + getFuel());
    }
}