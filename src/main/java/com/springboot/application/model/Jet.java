package com.springboot.application.model;

public class Jet extends Aircraft {
    // Unique to Jet - gas-turbine, specific fuel
    private String gasTurbineType;
    private String fuel;

    // Default Constructor
    public Jet() {}

    // Default Constructor
    public Jet(String tailNum, String cockpitLoc, String wingsLength, int wheelsNum, int length, int width, String fuel, String gasTurbine) {
        super(tailNum, cockpitLoc, wingsLength, wheelsNum, length, width);
        this.fuel = fuel;
        this.gasTurbineType = gasTurbine;
    }

    // Setters and Getters
    public void setFuel(String fuel) {
		this.fuel = fuel;
	}
	public String getFuel() {
		return fuel;
	}
    public void setGasTurbineType(String gasTurbine) {
		this.gasTurbineType = gasTurbine;
	}
	public String getGasTurbineType() {
		return gasTurbineType;
	}

    // Method override
    @Override
    public void printDetails() {
        System.out.println("Tail Number: " + getTailNumber());
        System.out.println("Cockpit Location: " + getCockpitLocation());
        System.out.println("Wings Span Length: " + getWingsSpan());
        System.out.println("Number of Wheels: " + getNumberOfWheels());
        System.out.println("Length: " + getLength());
        System.out.println("Width: " + getWidth());
        System.out.println("Name of Fuel: " + getFuel());
        System.out.println("Type of Gas-Turbine: " + getGasTurbineType());
    }
}