import java.util.*;

public class Main {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         
         int N = sc.nextInt();
         int K = sc.nextInt();  
         int[] arr = new int[N];
         for(int i=0;i<N;i++){
             arr[i] = sc.nextInt();
         }

        System.out.println(longestSubarrayWithSumK(arr,N,K));
         
     }
     
     public static int longestSubarrayWithSumK(int[] arr, int N, int K){
          // write your code here
        // HashMap to store (prefix_sum, index)
        HashMap<Integer, Integer> prefixSumMap = new HashMap<>();
        int cumulativeSum = 0;
        int maxLength = 0;
        
        for (int i = 0; i < N; i++) {
            cumulativeSum += arr[i];
            
            // Check if the whole subarray from the start sums to K
            if (cumulativeSum == K) {
                maxLength = i + 1;
            }
            
            // Check if there is a prefix sum that equals cumulativeSum - K
            if (prefixSumMap.containsKey(cumulativeSum - K)) {
                int length = i - prefixSumMap.get(cumulativeSum - K);
                maxLength = Math.max(maxLength, length);
            }
            
            // Store the cumulative sum with the current index if not already present
            if (!prefixSumMap.containsKey(cumulativeSum)) {
                prefixSumMap.put(cumulativeSum, i);
            }
        }
        
        return maxLength;
    }

}

To solve the problem of finding the longest subarray with a given sum 
𝐾
K, we can use a HashMap to store the prefix sums and their indices. The main idea is to keep track of the cumulative sum at each index and check if the current cumulative sum minus 
𝐾
K has been seen before. If it has, it means there is a subarray that sums to 
𝐾
K.

Here is the step-by-step solution:

Initialize Variables:

A HashMap to store the prefix sums and their corresponding indices.
A variable to keep track of the current cumulative sum.
A variable to store the length of the longest subarray found so far.
Iterate Through the Array:

Update the cumulative sum.
Check if the cumulative sum equals K; if so, update the longest subarray length.
Check if the cumulative sum minus 𝐾
K is present in the HashMap; if so, calculate the length of the subarray and update the longest length if this subarray is longer.
If the cumulative sum is not already in the HashMap, store it along with the current index.
Return the Longest Subarray Length.

Explanation
HashMap for Prefix Sums:
The HashMap prefixSumMap stores cumulative sums and their first occurrence index.
Cumulative Sum Calculation:
As we iterate through the array, we keep a running sum of the elements (cumulativeSum).
Checking for Valid Subarrays:
If cumulativeSum equals K, it means the subarray from the start to the current index sums to K.
If prefixSumMap contains cumulativeSum - K, it means there exists a subarray that sums to 𝐾
K between the indices stored in the HashMap and the current index.
Updating the Maximum Length:
We keep track of the maximum length of such subarrays found so far and update it whenever a longer one is found.
This solution has a time complexity of 

O(N) and a space complexity of 

O(N), making it efficient for the given constraints.







