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
        if (num <= 1) {
            return num;
        }
        
        int a = 0;
        int b = 1;
        
        for (int i = 2; i <= num; i++) {
            int next = a + b;
            a = b;
            b = next;
        }
        
        return b;
    }
}
