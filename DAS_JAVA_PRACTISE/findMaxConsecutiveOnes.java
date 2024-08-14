import java.util.Scanner;

public class Main {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         
         int n = sc.nextInt();
         int k = sc.nextInt();
         int[] arr = new int[n];
         for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
         }
        int res = findMaxConsecutiveOnes(arr,k);
         System.out.println(res);
     }
     
     public static int findMaxConsecutiveOnes(int[] arr,int k){
          // write your code here
                  int left = 0; // Start of the window
        int maxLength = 0; // Maximum length of the window found so far
        int zerosCount = 0; // Number of zeros in the current window

        for (int right = 0; right < arr.length; right++) {
            if (arr[right] == 0) {
                zerosCount++;
            }

            // If the number of zeros exceeds k, shrink the window from the left
            while (zerosCount > k) {
                if (arr[left] == 0) {
                    zerosCount--;
                }
                left++;
            }

            // Update the maximum length of the window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
     }


}


To solve the problem of finding the maximum number of consecutive 1s in a binary array with at most k zeros that can be flipped to 1s, we can use the sliding window technique. This approach helps us efficiently determine the maximum length of such a subarray.

Explanation:
Sliding Window Technique:

We'll use two pointers (left and right) to maintain a window over the array.
The window will expand by moving the right pointer and include more elements.
If the number of zeros in the current window exceeds k, we will move the left pointer to the right to shrink the window until the number of zeros is less than or equal to k.
The goal is to find the maximum window size that contains at most k zeros.
Result:

The length of the maximum window during the iteration will be our answer.