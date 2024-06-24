import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputLine = sc.nextInt(); 
        printPattern(inputLine);
    }

    public static void printPattern(int n) {
        // Loop through rows
        for (int i = n; i > 0; i--) {
            // Loop through columns
            for (int j = 0; j < i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
