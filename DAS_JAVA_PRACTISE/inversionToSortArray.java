import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(inversion(n, arr));
    }
    
    public static long inversion(int n, int[] arr) {
        int[] temp = new int[n];
        return mergeSortAndCount(arr, temp, 0, n - 1);
    }
    
    private static long mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = (left + right) / 2;
            count += mergeSortAndCount(arr, temp, left, mid);
            count += mergeSortAndCount(arr, temp, mid + 1, right);
            count += mergeAndCount(arr, temp, left, mid, right);
        }
        return count;
    }
    
    private static long mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;    // Starting index for left subarray
        int j = mid + 1; // Starting index for right subarray
        int k = left;    // Starting index to be merged
        long count = 0;
        
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
                count += (mid - i + 1); // Number of elements remaining in the left subarray
            }
        }
        
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        
        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }
        
        return count;
    }
}

To solve the problem of counting the number of inversions required to sort an array, we can use a modified merge sort algorithm. An inversion is defined as a pair of indices (i, j) such that i < j and arr[i] > arr[j]. Counting inversions using a naive approach would be too slow for larger arrays, so we use a divide-and-conquer approach to achieve a more efficient solution.

Here's how the merge sort algorithm can be adapted to count inversions:

Divide: Recursively divide the array into two halves until each subarray contains a single element.
Conquer: Count inversions within each half of the array and during the merging process.
Combine: Merge the two halves while counting inversions that span across the two halves.
In the merging process, if an element from the right half is smaller than an element from the left half, it contributes to inversions equal to the number of remaining elements in the left half, because all these elements are greater than the current element from the right half.
