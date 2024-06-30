package evaluations.level2.implementations;

import evaluations.level2.RocketShip;

public class SatelliteRocketShip extends RocketShip {
    @Override
    public int fuelCapacity() {
        return 1000;
    }

    @Override
    public int payload() {
        return 1000;
    }

    @Override
    public void typesOfPayloads() {
        System.out.println("This rocket will carry: Satellites");
    }
}
