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
       System.out.println(countSubarrayWithSumK(arr,k));  
         
     }
     
     public static int countSubarrayWithSumK(int[] arr, int K){
          // write your code here
        // Map to store the frequency of cumulative sums
        Map<Integer, Integer> sumMap = new HashMap<>();
        int count = 0;
        int currentSum = 0;

        // Initialize the map with sum 0 having one occurrence
        sumMap.put(0, 1);

        for (int num : arr) {
            currentSum += num;

            // Check if there is a subarray that sums to k
            if (sumMap.containsKey(currentSum - K)) {
                count += sumMap.get(currentSum - K);
            }

            // Add the current sum to the map
            sumMap.put(currentSum, sumMap.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

}


Explanation:
Map Usage:

The sumMap hashmap stores the cumulative sum at each index as a key and the number of times this sum has occurred as its value.
Cumulative Sum:

As you iterate through the array, you calculate the cumulative sum (currentSum). The idea is that if currentSum - k has been seen before, it means there is a subarray that sums to k.
Counting Subarrays:

For each element in the array, you check if (currentSum - k) exists in the map. If it does, it means there are sumMap.get(currentSum - k) subarrays that sum to k, so you add this to the count.
Updating the Map:

After checking, you update the map with the current cumulative sum.
Example:
For an array arr = [1, 2, 3] and k = 3:

The subarrays [1, 2] and [3] both sum to 3. The output would be 2.