package org.skillovilla.level2;

public class Car extends Vehicle{
    private int numberOfWheels;

    public Car(String brand, String model, int numberOfWheels) {
        super(brand, model);
        this.numberOfWheels = numberOfWheels;
    }

    public int getNumberOfWheels() {
        return numberOfWheels;
    }
}
