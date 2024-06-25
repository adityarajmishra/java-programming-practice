package org.skillovilla.constructor.level2;


public class Car {
    String make;
    String model;

    // Uncomment the parameterized constructor
    public Car(String make, String model) {
        this.make = make;
        this.model = model;
        System.out.println("Car make: " + make + ", model: " + model);
    }
}
