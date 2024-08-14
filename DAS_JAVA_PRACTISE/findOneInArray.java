import java.util.*;


public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
	
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        
        int[] arr= new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(findOne(arr,n));
    }
    
    public static int findOne(int[] arr,int n){
        //write your code here
                int low = 0;
        int high = n - 1;
        int firstOneIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // If we find a 1, move left to find the first occurrence of 1
            if (arr[mid] == 1) {
                firstOneIndex = mid;
                high = mid - 1;
            } 
            // If mid element is 0, we need to move right to find the first 1
            else {
                low = mid + 1;
            }
        }

        // If there are no 1's in the array
        if (firstOneIndex == -1) {
            return 0;
        }

        // Count of 1's is from firstOneIndex to the end of the array
        return n - firstOneIndex;
    }

}


To solve the problem of counting the number of ones (1s) in a sorted binary array (which contains only 0s and 1s), we can take advantage of the fact that the array is sorted. The optimal approach would be to use binary search to find the first occurrence of 1 and then calculate the count of 1s based on its position.

Steps:
Binary Search:

We will apply binary search to find the index of the first occurrence of 1 in the array.
Since the array is sorted, all the elements before this index will be 0s, and all the elements after and including this index will be 1s.
Calculate the Count of 1s:

Once we find the index of the first 1, the count of 1s will simply be n - index, where n is the size of the array.
Edge Cases:

If there are no 1s in the array, return 0.