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
          double res =findMaxAverage(arr, k);
	   String output = String.format("%.5f", res);
         System.out.println(output);
         
     }
     
     public static double findMaxAverage(int[] arr, int k){
          // write your code here
        int n = arr.length;
        if (n < k) {
            return 0.0;  // Return 0 if array length is less than k (edge case)
        }
        
        // Calculate the sum of the first k elements
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        
        double maxSum = sum;
        
        // Slide the window across the array
        for (int i = k; i < n; i++) {
            sum = sum - arr[i - k] + arr[i];
            if (sum > maxSum) {
                maxSum = sum;
            }
        }
        
        // Calculate the maximum average
        return maxSum / k;
    }

}

To solve the problem of finding the maximum average of a subarray of length k, we can use the sliding window technique. This technique allows us to calculate the sum of a subarray efficiently and update it as we slide the window across the array. Here's how you can implement it in Java:

Sliding Window Algorithm Steps:
Initialize the sum of the first window: Calculate the sum of the first k elements.
Slide the window: Move the window one element to the right, subtract the element that is left behind, and add the new element that enters the window.
Update the maximum sum: Keep track of the maximum sum encountered during the sliding process.
Calculate the average: Divide the maximum sum by k to get the maximum average.


Explanation:
Input Reading:
The main method reads the input using a Scanner.
The size of the array (n), the subarray length (k), and the elements of the array are read.
Sliding Window Calculation:
The findMaxAverage method calculates the maximum average of any subarray of length k.
Initialization:
We first calculate the sum of the initial window of size k.
Sliding the Window:
We slide the window from the start to the end of the array, updating the sum by subtracting the element that is left behind and adding the new element.
We keep track of the maximum sum encountered.
Calculate the Average:
We divide the maximum sum by k to get the maximum average.
Printing the Result:
The result is printed with 5 decimal places using String.format().
