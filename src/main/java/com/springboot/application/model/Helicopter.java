package com.springboot.application.model;

public class Helicopter extends Aircraft {
    // Unique to Heli - blade and rotor
    private int lengthOfBlade;
    private int rotorRpm;

    // Default Constructor
    public Helicopter() {}

    // Default Constructor
    public Helicopter(String tailNum, String cockpitLoc, String wingsLength, int wheelsNum, int length, int width, int bladeLength, int rpm) {
        super(tailNum, cockpitLoc, wingsLength, wheelsNum, length, width);
        this.lengthOfBlade = bladeLength;
        this.rotorRpm = rpm;
    }

    // Setters and Getters
    public void setBladeLength(int bladeLength) {
		this.lengthOfBlade = bladeLength;
	}
	public int getBladeLength() {
		return lengthOfBlade;
	}
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
        System.out.println("Cockpit Location: " + getCockpitLocation());
        System.out.println("Wings Span Length: " + getWingsSpan());
        System.out.println("Number of Wheels: " + getNumberOfWheels());
        System.out.println("Length: " + getLength());
        System.out.println("Width: " + getWidth());
        System.out.println("Length of Blade: " + getBladeLength());
        System.out.println("Rotor RPM: " + getRotorRpm());
    }
}