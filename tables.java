import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        printMultiples(n);
    }


    private static void printMultiples(int N) {
       //Write your code here
        for (int i = 1; i <= 10; i++) {
            System.out.println(N + " x " + i + " = " + N * i);
        }

    }

}