import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        generateFibonacciSequence(n);
    }


    private static void generateFibonacciSequence(int n) {
        if (n <= 0) {
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.print(fibonacci(i));
            } else {
                System.out.print(" " + fibonacci(i));
            }
        }
    }

    private static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
