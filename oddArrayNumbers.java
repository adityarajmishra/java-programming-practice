import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0 ;i<n ;i++){
           arr[i] = sc.nextInt();
        }
        solve(arr,n);
         
    }
    
    public static void solve(int[] arr, int n) {
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 != 0) {
                count++; // Increment the count if the number is odd
            }
        }
        
        System.out.println(count); // Print the final count of odd numbers
    }
}
