import java.util.*;

public class Main {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         
         int n = sc.nextInt();
         
         int[] arr = new int[n];
                for(int i=0;i<n;i++){
             arr[i] = sc.nextInt();
         }
         maxSubArray(arr);
        
         
     }
     
     public static void maxSubArray(int[] arr){
          // write your code here
        int max_current = arr[0];
        int max_global = arr[0];

        for (int i = 1; i < arr.length; i++) {
            max_current = Math.max(arr[i], max_current + arr[i]);
            if (max_current > max_global) {
                max_global = max_current;
            }
        }

        System.out.println(max_global);
    }

}


To solve the problem of finding the maximum sum of a contiguous subarray, we can use Kadane's Algorithm. This algorithm efficiently finds the maximum sum subarray in linear time. Here's how you can implement it in Java:

Kadane's Algorithm Steps:
Initialize two variables:
max_current to keep track of the maximum sum of the subarray ending at the current position.
max_global to keep track of the overall maximum sum found so far.
Iterate through the array:
Update max_current to be the maximum of the current element alone or the current element plus the max_current sum so far.
Update max_global to be the maximum of max_global and max_current.

Explanation:
Initialization:
max_current is initialized to the first element of the array.
max_global is also initialized to the first element of the array.
Iteration:
For each element in the array starting from the second element, update max_current to be the maximum of the current element or the current element plus max_current.
Update max_global to be the maximum of max_global and max_current.
Output:
After the loop, max_global contains the maximum sum of any contiguous subarray in the given array.

