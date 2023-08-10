package com.springboot.application.objects;

public class Glider extends Aircraft {
    // Unique to Glider - no engine, uses tow plane
    private String towPlane;

    // Default Constructor
    public Glider() {}

    // Default Constructor
    public Glider(String tailNum, String cockpitLoc, String wingsLength, int wheelsNum, int length, int width, String towPlaneName) {
        super(tailNum, cockpitLoc, wingsLength, wheelsNum, length, width);
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
        System.out.println("Cockpit Location: " + getCockpitLocation());
        System.out.println("Wings Span Length: " + getWingsSpan());
        System.out.println("Number of Wheels: " + getNumberOfWheels());
        System.out.println("Length: " + getLength());
        System.out.println("Width: " + getWidth());
        System.out.println("Name of Towplane: " + getTowPlaneName());
    }
}