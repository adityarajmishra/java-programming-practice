import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        boolean isPowerOfThree = isPowerOfThree(n);
        System.out.println(isPowerOfThree);
    }

    public static boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n /= 3;
        }

        return n == 1;
    }
}

