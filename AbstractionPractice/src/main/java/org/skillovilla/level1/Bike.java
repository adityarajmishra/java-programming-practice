package org.skillovilla.level1;

public class Bike extends Vehicle{
    private boolean hasCarrier;

    public Bike(boolean hasCarrier) {
        this.hasCarrier = hasCarrier;
    }

    @Override
    public void start() {
        System.out.println("Bike is starting.");
    }

    @Override
    public void stop() {
        System.out.println("Bike is stopping.");
    }

    public boolean hasCarrier() {
        return hasCarrier;
    }
}
