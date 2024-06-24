import java.util.Scanner;


public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        leapYear(a);
        
    }

    public static void leapYear(int a) {
        // Check if the year is a leap year or a common year
        if ((a % 4 == 0 && a % 100 != 0) || (a % 400 == 0)) {
            System.out.println("LEAP YEAR");
        } else {
            System.out.println("COMMON YEAR");
        }
    }
}
