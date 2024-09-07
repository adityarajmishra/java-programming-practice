import java.util.*;

public class Main {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         
         int n = sc.nextInt();
         int k = sc.nextInt();

         int[] arr = new int[n];

         for(int i=0;i<n;i++){
             arr[i] = sc.nextInt();
         }

         int res = longestOnes(arr,k);

	     System.out.println(res);
         
     }
     
     public static int longestOnes(int[] arr,int k){
          // write your code here
        int left = 0;
        int maxLen = 0;
        int zeroCount = 0;

        // Use sliding window to find the longest subarray with at most k zeros
        for (int right = 0; right < arr.length; right++) {
            // If we encounter a zero, increase zero count
            if (arr[right] == 0) {
                zeroCount++;
            }

            // If zero count exceeds k, shrink the window from the left
            while (zeroCount > k) {
                if (arr[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Calculate the length of the current valid window
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

}


To solve this problem, the goal is to find the maximum number of consecutive 1s in the binary array arr, with the ability to flip at most k zeros to 1s.

This is a variation of the "sliding window" or "two-pointer" problem. Here's the approach:

Approach:
Sliding Window Technique: Use two pointers (left and right) to maintain a window of elements in the array.
Count of Zeros: Keep track of the number of zeros in the current window. If the number of zeros exceeds k, we shrink the window from the left.
Max Length: For every valid window (with at most k zeros), calculate the length and keep track of the maximum length.

Explanation:
Two Pointers (left and right): right moves to expand the window, while left moves to shrink the window when we exceed k zeros.
Zero Counting: We increment zeroCount when we encounter a zero. If zeroCount > k, we increment left and reduce zeroCount accordingly.
Max Length: For every valid window (when zeroCount ≤ k), we calculate the length of the window and keep track of the maximum.
