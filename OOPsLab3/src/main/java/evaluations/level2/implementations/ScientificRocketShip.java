package evaluations.level2.implementations;

import evaluations.level2.RocketShip;

public class ScientificRocketShip extends RocketShip {
    @Override
    public int fuelCapacity() {
        return 2000;
    }

    @Override
    public int payload() {
        return 1500;
    }

    @Override
    public void typesOfPayloads() {
        System.out.println("This rocket will carry: Scientific Equipments");
    }
}
