public class Main {
    public static void main(String[] args) {
        Car myCar = new Car();  // Create an object of the Car class
        myCar.drive();          // Call the drive method
    }
}

class Car {
    // Zero-argument constructor
    public Car() {
        // Constructor does not need to do anything for this task
    }

    // Method to print the message
    public void drive() {
        System.out.println("Let's go!!");
    }
}