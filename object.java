import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read input values
        String name = sc.next();
        String location = sc.next();
        int quantity = sc.nextInt();
        
        // Create an instance of Fruit class
        Fruit fr = new Fruit(name, location, quantity);
        
        // Call numQuantity method
        fr.numQuantity();
    }
}

class Fruit {
    // Attributes
    private String name;
    private String location;
    private int quantity;
    
    // Constructor
    public Fruit(String name, String location, int quantity) {
        this.name = name;
        this.location = location;
        this.quantity = quantity;
    }
    
    // Method to print the quantity message
    public void numQuantity() {
        System.out.println("There are a total of " + quantity + " " + name + " boxes.");
    }
}
