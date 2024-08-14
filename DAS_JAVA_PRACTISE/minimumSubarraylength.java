import java.util.*;

public class Main {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         
         int n = sc.nextInt();
         int target = sc.nextInt(); 
 	 
         int[] arr = new int[n];
           for(int i=0;i<n;i++){
             arr[i] = sc.nextInt();
         }
           
         System.out.println(minimumSubarraylength(arr,target));
         
     }
     
    public static int minimumSubarraylength(int[] arr, int target) {
          // write your code here
                  int n = arr.length;
        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int currentSum = 0;

        for (int end = 0; end < n; end++) {
            currentSum += arr[end];

            // Shrink the window as long as the sum is greater than or equal to the target
            while (currentSum >= target) {
                minLength = Math.max(1, Math.min(minLength, end - start + 1));
                currentSum -= arr[start];
                start++;
            }
        }

        // If no valid subarray is found, return 0
        return minLength == Integer.MAX_VALUE ? 0 : minLength;
     }

}


To solve the problem of finding the minimum length of a contiguous subarray whose sum is greater than or equal to a given target, we can use the sliding window technique. This approach is efficient and helps in reducing the time complexity to O(n).

Explanation:
Sliding Window Technique:

We'll maintain a window defined by two pointers (start and end) that slides over the array.
We'll expand the window by moving the end pointer to include more elements until the sum of elements in the window is greater than or equal to the target.
Once the sum is greater than or equal to the target, we'll try to shrink the window from the left by moving the start pointer to find the smallest possible window that still satisfies the condition.
Result:

The minimum length of such a window (subarray) is tracked throughout the process.
If no such window is found, the function should return 0 (or an indication that no subarray satisfies the condition).