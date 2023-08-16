package com.springboot.application.model;

public class Glider extends Aircraft {
    // Unique to Glider - no engine, uses tow plane
    private String towPlane;

    // Default Constructor
    public Glider() {}

    // Default Constructor
    public Glider(String tailNum, int wheelsNum, int length, String towPlaneName) {
        super(tailNum, wheelsNum, length);
        this.towPlane = towPlaneName;
    }

    // Setter and Getter
    public void setTowPlaneName(String towPlaneName) {
		this.towPlane = towPlaneName;
	}
	public String getTowPlaneName() {
		return towPlane;
	}

    // Method override
    @Override
    public void printDetails() {
        System.out.println("Tail Number: " + getTailNumber());
        System.out.println("Number of Wheels: " + getNumberOfWheels());
        System.out.println("Length: " + getLength());
        System.out.println("Name of Towplane: " + getTowPlaneName());
    }
}