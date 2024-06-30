package evaluations.level4.implementations;

import evaluations.level4.Vehicle;

public class Car implements Vehicle {
    private int speed = 0;

    public int getSpeed() {
        return speed;
    }

    @Override
    public void start() {
        this.speed = 1;
        System.out.println("Car started");
    }

    @Override
    public void accelerate(int speed) {
        this.speed += speed;
        System.out.println("Car accelerated to " + this.speed);
    }

    @Override
    public void brake() {
        this.speed = 0;
        System.out.println("Car stopped");
    }

    @Override
    public String toString() {
        return "Car{" +
                "speed=" + speed +
                '}';
    }
}
