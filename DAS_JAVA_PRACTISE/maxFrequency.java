import java.util.*;

public class Main {
      public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
       
        int[] arr= new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
       
        int res = maxFrequency(arr,k);

       
	    System.out.println(res);
         
     }
     
     public static int maxFrequency(int[] arr, int k){
          // write your code here
        Arrays.sort(arr);  // Sort the array
        int left = 0;
        long total = 0;  // To keep track of the sum of the current window
        int maxFreq = 0;

        // Sliding window approach
        for (int right = 0; right < arr.length; right++) {
            // Add arr[right] to the total
            total += arr[right];

            // Check if the total operations required to make all elements
            // in the current window equal to arr[right] exceed k
            while (arr[right] * (right - left + 1) > total + k) {
                total -= arr[left];  // Remove arr[left] from total
                left++;  // Shrink the window from the left
            }

            // Update the max frequency
            maxFreq = Math.max(maxFreq, right - left + 1);
        }

        return maxFreq;
    }


}


The problem you're describing is about finding the maximum frequency of an element in an array after performing at most k operations. Each operation allows you to increment any element by 1. The goal is to make as many elements as possible equal to some number in the array by using these operations.

To solve this problem efficiently, we can use a sliding window approach along with sorting. Here's the approach:

Approach:
Sort the array: Sorting will allow us to group numbers together and make it easier to calculate how many operations are needed to make all elements in a window equal to the largest element in that window.
Sliding Window: We use two pointers (left and right) to define a sliding window. The window expands by increasing right, and if the total operations required to make all numbers in the window equal to the maximum number (i.e., arr[right]) exceeds k, we shrink the window by moving left.
Calculate the total operations: For any subarray from arr[left] to arr[right], we need to make all the numbers equal to arr[right]. The total operations required to do this is calculated as:

operations=arr[right]×window size−sum of the window elements
Maximize the window size: Keep track of the largest window where the total operations do not exceed k.


Explanation:
Sorting: We sort the array so that we can focus on making elements equal to the largest element in a window.
Sliding Window: The window starts from left and expands by increasing right. If the total operations to make all elements in the window equal to arr[right] exceed k, we move left to shrink the window.
Total Calculation: We maintain the total sum of elements in the current window to efficiently calculate the operations required.