package evaluations.level3;

public interface ModernCar {

    public String type();

    default int numberOfEngines() {
        return 1;
    }

    default String material() {
        return "Vibranium";
    }
}
