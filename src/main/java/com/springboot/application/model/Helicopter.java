package com.springboot.application.model;

public class Helicopter extends Aircraft {
    // Unique to Heli - rotor
    private int rotorRpm;

    // Default Constructor
    public Helicopter() {}

    // Default Constructor
    public Helicopter(String tailNum, int wheelsNum, int length, int rpm) {
        super(tailNum, wheelsNum, length);
        this.rotorRpm = rpm;
    }

    // Setters and Getters
    public void setRotorRpm(int rpm) {
		this.rotorRpm = rpm;
	}
	public int getRotorRpm() {
		return rotorRpm;
	}

    // Method override
    @Override
    public void printDetails() {
        System.out.println("Tail Number: " + getTailNumber());
        System.out.println("Number of Wheels: " + getNumberOfWheels());
        System.out.println("Length: " + getLength());
        System.out.println("Rotor RPM: " + getRotorRpm());
    }
}