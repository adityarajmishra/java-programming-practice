package evaluations.level3.implementations;

import evaluations.level3.ModernCar;

public class InvisibleCar implements ModernCar {

    @Override
    public String type() {
        return "Invisible Car";
    }

    @Override
    public String material() {
        return "Kryptonian Crystal";
    }
}
