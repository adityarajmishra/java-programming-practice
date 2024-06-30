package evaluations.level2;

public abstract class RocketShip {

    abstract public int fuelCapacity();
    abstract public int payload();

    public void typesOfPayloads() {
        System.out.println("This rocket will carry: Satellites, Space Probes, Crew, Scientific Instruments");
    }

    public boolean interplanetary() {
        return true;
    }
}
