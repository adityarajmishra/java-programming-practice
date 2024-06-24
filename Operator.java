import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
	//Write your code here
            Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();
        
        int num2 = scanner.nextInt();

        char operator = scanner.next().charAt(0);


        // Perform the calculation based on the operator
        int result;
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    System.out.println("Error: Division by zero is not allowed.");
                    scanner.close();
                    return;
                }
                break;
            default:
                System.out.println("Error: Invalid operator.");
                scanner.close();
                return;
        }

        // Print the result
        System.out.println(result);
    }
}