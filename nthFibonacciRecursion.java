import java.util.*;


public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputLine = sc.nextInt();
        int ans = nthFibonacci(inputLine);
        System.out.println(ans);        
    }


    public static int nthFibonacci(int num) {
        // Base cases
        if (num <= 1) {
            return num;
        }
        // Recursive call
        return nthFibonacci(num - 1) + nthFibonacci(num - 2);
    }
}
