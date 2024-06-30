package evaluations.level4.implementations;

import evaluations.level4.Vehicle;

public class Bike implements Vehicle {
    private int speed;

    public int getSpeed() {
        return speed;
    }

    @Override
    public void start() {
        this.speed = 1;
        System.out.println("Bike started");
    }

    @Override
    public void accelerate(int speed) {
        this.speed += speed;
        System.out.println("Bike accelerated to " + this.speed);
    }

    @Override
    public void brake() {
        this.speed = 0;
        System.out.println("Bike stopped");
    }
}