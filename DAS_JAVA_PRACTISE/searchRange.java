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

        int target=sc.nextInt();

        for(int i : searchRange(arr,target)){
            System.out.print(i+" ");
        }

    }
    public static int[] searchRange(int[] arr,int target){
        //write your code here
        int[] result = {-1, -1};
        
        result[0] = findFirst(arr, target);
        result[1] = findLast(arr, target);
        
        return result;
    }

    // Helper function to find the first occurrence of the target
    private static int findFirst(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int firstIndex = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == target) {
                firstIndex = mid;  // Update firstIndex
                high = mid - 1;    // Keep searching to the left
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return firstIndex;
    }

    // Helper function to find the last occurrence of the target
    private static int findLast(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        int lastIndex = -1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (arr[mid] == target) {
                lastIndex = mid;   // Update lastIndex
                low = mid + 1;     // Keep searching to the right
            } else if (arr[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        
        return lastIndex;
    }

}

To solve this problem efficiently with a time complexity of 
𝑂
(
log
⁡
𝑛
)
O(logn), we can use binary search to find the starting and ending positions of the target value in the sorted array.

Approach:
Binary Search: Perform two binary searches:
One to find the first occurrence of the target.
One to find the last occurrence of the target.
Key Idea:
For the first occurrence, modify the binary search such that you keep searching the left half even if you find the target, to ensure it's the first occurrence.
For the last occurrence, modify the binary search to search the right half even after finding the target, to ensure it's the last occurrence.
Steps:
Use binary search to locate the target's first occurrence and last occurrence.
If the target is not found, return [-1, -1].

Explanation:
Binary Search for First Occurrence:

We search for the target using binary search.
When we find the target at mid, we update firstIndex but continue to search in the left half (high = mid - 1) to ensure we get the first occurrence.
Binary Search for Last Occurrence:

Similarly, we search for the target, and when found at mid, we update lastIndex but continue to search in the right half (low = mid + 1) to ensure we get the last occurrence.
If the target is not found:

Both findFirst and findLast will return -1, and the result will be [-1, -1].
Time Complexity:
Each binary search takes 
𝑂
(
log
⁡
𝑛
)
O(logn) time.
Since we perform two binary searches (one for the first occurrence and one for the last), the total time complexity is 
𝑂
(
log
⁡
𝑛
)
O(logn).
