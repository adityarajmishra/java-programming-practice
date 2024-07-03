package org.skillovilla.level1;

public class Car extends Vehicle{
    private int numberOfDoors;

    public Car(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
    }

    @Override
    public void start() {
        System.out.println("Car is starting with " + numberOfDoors + " doors.");
    }

    @Override
    public void stop() {
        System.out.println("Car is stopping.");
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }
}
