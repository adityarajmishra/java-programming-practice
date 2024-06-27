import java.util.Scanner;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        // Write your code here
        if (num % 3 == 0 && num % 5 == 0) {
            System.out.println("FizzBuzz");
        } else if (num % 5 == 0) {
            System.out.println("Fizz");
        } else if (num % 3 == 0) {
            System.out.println("Buzz");
        } else {
            System.out.println("Not Found");
        }
    }
}
