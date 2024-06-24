import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); 
        //Write your code here
        for (int i = 0; i < N; i++) { // Number of lines
            for (int j = 0; j < N-i; j++) { // Number of elements in each line
                int currentNumber = j+1;
                System.out.print(currentNumber + " ");
            }
            System.out.println(); // Move to the next line
        }
        
    }

}
