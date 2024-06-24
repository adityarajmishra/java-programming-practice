import java.util.*;

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
    
    public static void solve(int[] arr, int n){
        // Sort the array
        Arrays.sort(arr);
        
        // Find the median
        int medianIndex = n / 2;
        int median = arr[medianIndex];
        
        // Print the median
        System.out.println(median);
    }
}
