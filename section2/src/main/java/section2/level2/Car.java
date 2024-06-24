package section2.level2;

public class Car {

    public final String model;
    public final String brand;
    public int numberOfTyres;
    public int mileage;
    public static int numberOfCarsCreated = 0;
    public static final String MANUFACTURED_BY = "The Car Company";

    public Car(String model, String brand, int numberOfTyres, int mileage) {
        this.model = model;
        this.brand = brand;
        this.numberOfTyres = numberOfTyres;
        this.mileage = mileage;
        numberOfCarsCreated++;
    }
}
