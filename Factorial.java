import java.util.*;

public class Main {
    public static void main(String[] args) {
	//Write your code here
        Scanner scanner = new Scanner(System.in);

        int num1 = scanner.nextInt();

        for (int i = 1; i <= num1; i++) {
            if (num1 % i == 0) {  // Check if i is a divisor of num1
                System.out.println(i);
            }
        }

        scanner.close();
    }

       

}