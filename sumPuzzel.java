import java.util.Scanner;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        while (true) {
            int N = sc.nextInt(); // Read the next integer
            if (N < 0) {
                break; // Exit the loop if a negative integer is encountered
            }
            sum += N; // Add the positive integer to the sum
        }

        // Print the final sum
        System.out.println(sum);

    }
    
}
