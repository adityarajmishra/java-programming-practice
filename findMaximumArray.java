import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
         int n =  sc.nextInt();
         int[] arr = new int[n];
         for(int i=0;i<n;i++)arr[i] = sc.nextInt();
        
         System.out.println( findMaximum(arr));
    }

    public static int findMaximum(int[] arr) {
        //Write your code here
        int maxElement = arr[0];
        
        // Traverse the array to find the maximum element
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > maxElement) {
                maxElement = arr[i];
            }
        }
        
        return maxElement;
    
    }
}

