import java.util.*;

public class Main {
    public static void main(String[] args) {
	//Write your code here
    Scanner scanner = new Scanner(System.in);
    int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
                    int a = 0, b = 1;
                    for (int i = 1; i <= n; i++) {
                        System.out.print(a + " ");
                        int next = a + b;
                        a = b;
                        b = next;
                    }
        }


       
    }
}