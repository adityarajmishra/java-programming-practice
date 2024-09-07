import java.util.*;

public class Main {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         
         int n = sc.nextInt();
          
         int[] arr = new int[n];
         for(int i=0;i<n;i++){
             arr[i] = sc.nextInt();
         }
        int res  = longestSubarrayWithSumZero(arr);
        System.out.println(res);
     }
     
     public static int longestSubarrayWithSumZero(int[] arr){
          // write your code here
        // HashMap to store the sum and corresponding index
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        
        int sum = 0;    // Initialize sum of elements
        int maxLen = 0; // Initialize max length of subarray with sum zero
        
        for(int i = 0; i < arr.length; i++) {
            sum += arr[i]; // Add current element to sum
            
            if(sum == 0) {
                maxLen = i + 1; // If sum is 0, the whole array till index i has sum 0
            }
            
            // If sum already exists in the map, update maxLen
            if(sumMap.containsKey(sum)) {
                maxLen = Math.max(maxLen, i - sumMap.get(sum));
            } else {
                // Otherwise, put the sum and index in the map
                sumMap.put(sum, i);
            }
        }
        
        return maxLen;
    }

}

To solve the problem of finding the length of the longest subarray with a sum of zero, we can use a HashMap to store the sum of elements from the beginning of the array to the current index. The key idea is that if we encounter the same sum at different indices, the subarray between these indices has a sum of zero.

Approach:
Initialize Variables:

sum = 0: This will keep track of the cumulative sum of elements as we iterate through the array.
maxLen = 0: This will store the length of the longest subarray found so far with a sum of zero.
A HashMap sumMap to store the sum and its corresponding index.
Iterate Through the Array:

For each element, add it to sum.
If sum is 0, then the subarray from the beginning to the current index has a sum of zero. Update maxLen accordingly.
If sum has been seen before (exists in sumMap), then there is a subarray with a sum of zero between the previous occurrence of this sum and the current index. The length of this subarray is the difference between the current index and the index stored in sumMap.
If sum is not in sumMap, store the current index as the value corresponding to sum.
Return the Maximum Length:

After iterating through the array, maxLen will contain the length of the longest subarray with a sum of zero.

Explanation:
sumMap stores the sum and the first occurrence of that sum.
sum += arr[i] adds the current element to the cumulative sum.
sum == 0: If the cumulative sum equals 0 at index i, the subarray from the beginning to i has a sum of 0.
sumMap.containsKey(sum): If the sum has been encountered before, it means the subarray between the previous occurrence of the sum and the current index has a sum of zero.
Example:
Consider the array arr = [1, -1, 3, 2, -2, -3, 3]:

The sum at different indices might be repeated, and those repeated sums indicate that the subarray between those indices has a sum of zero.
Output:
The function will return the length of the longest subarray with a sum of zero. This solution runs in O(n) time complexity, making it efficient for large inputs.