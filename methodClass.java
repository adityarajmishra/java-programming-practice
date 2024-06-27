import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String brand = sc.next();
        String color = sc.next();
        
        // Call the static method printBrandAndColor from the Car class
        Car.printBrandAndColor(brand, color);
    }
}

class Car {
    // Declare the static method printBrandAndColor according to the question
    public static void printBrandAndColor(String brand, String color) {
        System.out.println("The car brand is : " + brand + " and the color of the car is: " + color);
    }
}
