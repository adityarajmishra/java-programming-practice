package evaluations.level3.implementations;

import evaluations.level3.ModernCar;

public class FlyingCar implements ModernCar {
    @Override
    public String type() {
        return "Flying Car";
    }

    @Override
    public int numberOfEngines() {
        return 2;
    }
}
