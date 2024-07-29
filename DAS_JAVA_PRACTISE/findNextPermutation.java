import java.util.*;

public class Main {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         
         int n = sc.nextInt();
         int[] arr = new int[n];
                for(int i=0;i<n;i++){
             arr[i] = sc.nextInt();
         }
           findNextPermutation(arr);
        // Print the resulting array
        for(int num : arr){
            System.out.print(num + " ");
        }
     }
     
     public static void findNextPermutation(int[] arr ){
          // write your code here
        int n = arr.length;
        if (n <= 1) return;
        
        int i = n - 2;
        // Find the longest non-increasing suffix
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }
        
        // If the entire array is non-increasing, reverse it to get the smallest permutation
        if (i >= 0) {
            // Find the rightmost element that is larger than the pivot
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            // Swap the pivot with this element
            swap(arr, i, j);
        }
        
        // Reverse the suffix
        reverse(arr, i + 1, n - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            swap(arr, start, end);
            start++;
            end--;
        }
    }

}


To solve the problem of finding the next permutation of an array of integers, you can follow the algorithm based on the lexicographical ordering of permutations. Here is a step-by-step approach and the implementation:

Algorithm Steps:
Identify the longest non-increasing suffix: This is the part of the array where elements are in descending order. The pivot is the element just before this suffix.
Find the pivot: This is the element just before the longest non-increasing suffix.
Find the rightmost successor to the pivot in the suffix: This element will be just larger than the pivot.
Swap the pivot with this successor.
Reverse the suffix: This ensures that the suffix is now the smallest possible (in ascending order).

Explanation:
Find the pivot:
Iterate from the end of the array and find the first element that is smaller than the element next to it. This is the pivot point.
Find the successor:
From the end of the array, find the smallest element that is larger than the pivot element.
Swap the pivot and the successor:
Swap these two elements to ensure the next permutation is larger than the current one.
Reverse the suffix:
Reverse the elements after the pivot to get the next smallest lexicographical order.

