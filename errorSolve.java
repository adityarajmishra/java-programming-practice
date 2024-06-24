// Provided Java program with Error


import java.util.Scanner;

class Calculate {
    // Make the method static since we are calling it in a static context
    static int addition(int a, int b) {
        int sum = a + b;
        return sum;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int sum = Calculate.addition(a, b);

        System.out.println(sum);
    }
}
