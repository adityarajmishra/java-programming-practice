import java.util.*;

public class Main {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         
         int n = sc.nextInt();
         int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
         }
          
            System.out.println(countTriplets(arr));
          
     }
     
     public static int countTriplets(int[] arr){
          // write your code here
           int n = arr.length;
        int count = 0;
        
        // Sort the array
        Arrays.sort(arr);
        
        // Check for every triplet (i, j, k) where i < j < k
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] > arr[k]) {
                        count++;
                    } else {
                        // Since the array is sorted, no need to check further
                        break;
                    }
                }
            }
        }
        
        return count;
    }

}

To find the triplets in the array that can form the sides of a triangle, we need to ensure that for any triplet (a, b, c), the following conditions are satisfied:


a+b>c
a+c>b
b+c>a
Given the constraints and the need for an efficient solution, we can use sorting to reduce the problem complexity.

Optimized Approach:
Sort the array.
Use three nested loops to check for every triplet (i, j, k) such that i < j < k.
For each triplet, check if they can form a triangle using the above conditions.


Explanation:
Input Reading:
The main method reads the input array size n and the elements of the array.
Counting Triangle Triplets:
The array is sorted to simplify the triangle inequality checks.
Three nested loops iterate through all possible triplets (i, j, k) where i < j < k.
For each triplet, we check if arr[i] + arr[j] > arr[k] holds true.
If it does, the triplet can form a triangle and the count is incremented.
If not, break out of the innermost loop as further elements will not satisfy the condition due to the sorted order.
