package com.springboot.application.model;
// Abstract is being used because it's primarily for objects that are closely related (aircraft, heli, jet, etc)
public abstract class Aircraft {
    // Attributes/Properties - an Aircraft have these in common
    protected String tailNumber;
    protected int numberOfWheels;
    protected int length;

    // Default Constructor
    public Aircraft() {}

    // Default Constructor
    public Aircraft(String tailNum, int wheelsNum, int length) {
        this.tailNumber = tailNum;
        this.numberOfWheels = wheelsNum;
        this.length = length;
    }

    // Setters and Getters
    public void setTailNumber(String tailNum) {
        this.tailNumber = tailNum;
    }
    public String getTailNumber() {
        return tailNumber;
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
        System.out.println("Number of Wheels: " + getNumberOfWheels());
        System.out.println("Length: " + getLength());
    }
}