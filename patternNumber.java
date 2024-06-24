import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        //Write your code here
        int currentNumber = 1; // Start with 1

        // Write your code here
        for (int i = 1; i <= N; i++) { // Number of lines
            for (int j = 0; j < i; j++) { // Number of elements in each line
                System.out.print(currentNumber + " ");
                currentNumber++; // Increment the number to be printed
            }
            System.out.println(); // Move to the next line
        }
        
    }

}
