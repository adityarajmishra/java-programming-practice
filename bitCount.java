import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inputLine = sc.nextInt(); 
        int ans = countBits(inputLine);
        System.out.println(ans);
    }

    public static int countBits(int N) {
        //Write your code here
        return Integer.bitCount(N);      
    }
}
