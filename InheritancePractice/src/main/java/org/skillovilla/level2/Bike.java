package org.skillovilla.level2;

public class Bike extends Vehicle{
    private int numberOfWheels;

    public Bike(String brand, String model, int numberOfWheels) {
        super(brand, model);
        this.numberOfWheels = numberOfWheels;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }
}
