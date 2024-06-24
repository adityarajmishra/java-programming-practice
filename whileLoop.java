import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
	    Scanner sc= new Scanner(System.in);
	    int N=sc.nextInt();
	    //Write your code here
        int sum=0;
        // Write your code here
        while (N > 0) {
            if (N % 2 == 0) {
                sum += N;
            }
            N--;
        }

        // Print the final sum
        System.out.println(sum);

    }

}