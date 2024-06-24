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

        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                System.out.print(a);
            } else if (i == 1) {
                System.out.print(" " + b);
            } else {
                int next = a + b;
                System.out.print(" " + next);
                a = b;
                b = next;
            }
        }
    }
}
