import java.util.Scanner;

public class DivisibilityChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking inputs from the user
        System.out.print("Enter the value for x: ");
        int x = scanner.nextInt();
        
        System.out.print("Enter the value for y: ");
        int y = scanner.nextInt();
        
        System.out.print("Enter the value for n: ");
        int n = scanner.nextInt();
        
        int count = 0;
        
        // Loop through the range from 1 to n
        for (int i = 1; i <= n; i++) {
            // Check if i is divisible by x and not divisible by y
            if (i % x == 0 && i % y != 0) {
                count++;
            }
        }
        
        // Print the result
        System.out.println("Count of numbers divisible by " + x + " and not divisible by " + y + " is: " + count);
    }
}
