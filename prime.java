import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = findNumberOfPrimes(n);
        System.out.println(ans);

    }

    public static int findNumberOfPrimes(int n) {
        int count = 0; // Declare and initialize count outside the loop
        for (int i = 2; i < n; i++) { // Start from 2, the first prime number
            if (isPrime(i)) { // Check if the number is prime
                count++;
            }
        }
        return count; // Return the count instead of printing it
    }

    // Helper method to check if a number is prime
    private static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}



******************SECOND PART *********************

import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
    
        Scanner sc= new Scanner(System.in);
        int num=sc.nextInt();
    
        isPrime(num);
    }
    //Write your code here
    public static void isPrime(int num) {
        if (num <= 1) {
            System.out.println("Not a Prime Number");
            return;
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                System.out.println("Not a Prime Number");
                return;
            }
        }
        System.out.println("Prime Number");
    }
}
