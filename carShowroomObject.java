import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        // Create an object of Car class
        Car musk = new Car(1, "Electric", "Cyber truck", "Tesla", 60);
        
        // Call carDetails() method
        musk.carDetails();
    }
}

class Car {
    // Attributes
    private int model_no;
    private String type;
    private String name;
    private String brand;
    private int speed;

    // Constructor
    public Car(int model_no, String type, String name, String brand, int speed) {
        super();
        this.model_no = model_no;
        this.type = type;
        this.name = name;
        this.brand = brand;
        this.speed = speed;
    }

    // Methods
    public void moto() {
        System.out.println("It's a supra.");
    }

    public void drive() {
        System.out.println("Four wheel drive.");
    }

    public void carDetails() {
        System.out.println("Brand Name : " + brand);
        System.out.println("Car Name : " + name);
        System.out.println("Car Type : " + type);
        System.out.println("Car model No. : " + model_no);
        System.out.println("Car speed : " + speed);
    }
}
