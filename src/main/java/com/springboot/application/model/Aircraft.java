package com.springboot.application.model;
// Abstract is being used because it's primarily for objects that are closely related (aircraft, heli, jet, etc)
public abstract class Aircraft {
    // Attributes/Properties - an Aircraft have these in common
    protected String tailNumber;
    protected String cockpitLocation;
    protected String wingsSpan;
    protected int numberOfWheels;
    protected int length;
    protected int width;

    // Default Constructor
    public Aircraft() {}

    // Default Constructor
    public Aircraft(String tailNum, String cockpitLoc, String wingsLength, int wheelsNum, int length, int width) {
        this.tailNumber = tailNum;
        this.cockpitLocation = cockpitLoc;
        this.wingsSpan = wingsLength;
        this.numberOfWheels = wheelsNum;
        this.length = length;
        this.width = width;
    }

    // Setters and Getters
    public void setTailNumber(String tailNum) {
        this.tailNumber = tailNum;
    }
    public String getTailNumber() {
        return tailNumber;
    }
    public void setCockpitLocation(String cockpitLoc) {
        this.cockpitLocation = cockpitLoc;
    }
    public String getCockpitLocation() {
        return cockpitLocation;
    }
    public void setWingsSpan(String wingsLength) {
        this.wingsSpan = wingsLength;
    }
    public String getWingsSpan() {
        return wingsSpan;
    }
    public void setNumberOfWheels(int wheelsNum) {
        this.numberOfWheels = wheelsNum;
    }
    public int getNumberOfWheels() {
        return numberOfWheels;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public int getLength() {
        return length;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public int getWidth() {
        return width;
    }

    // Behaviors/Actions - these methods can be used or overridden by subclasses
    public void takeOff() {
        System.out.println("The Aircraft is taking off.");
    }
    public void fly() {
        System.out.println("The Aircraft is flying.");
    }
    public void land() {
        System.out.println("The Aircraft is landing.");
    }
    public void printDetails() {
        System.out.println("Tail Number: " + getTailNumber());
        System.out.println("Cockpit Location: " + getCockpitLocation());
        System.out.println("Wings Span Length: " + getWingsSpan());
        System.out.println("Number of Wheels: " + getNumberOfWheels());
        System.out.println("Length: " + getLength());
        System.out.println("Width: " + getWidth());
    }
}