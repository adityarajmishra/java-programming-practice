import java.util.*;

public class Main {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         
         int n = sc.nextInt();
         int[] arr = new int[n];
            for(int i=0;i<n;i++){
             arr[i] = sc.nextInt();
            }
         System.out.println(findSecondlargest(arr,n));
         
     }
     
     public static int findSecondlargest(int[] arr, int N){
          // write your code here
        if (N < 2) {
            // If there are fewer than 2 elements, return -1
            return -1;
        }
        
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        
        for (int i = 0; i < N; i++) {
            if (arr[i] > largest) {
                secondLargest = largest;
                largest = arr[i];
            } else if (arr[i] > secondLargest && arr[i] != largest) {
                secondLargest = arr[i];
            }
        }
        
        // If secondLargest is still Integer.MIN_VALUE, it means there's no second largest element
        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        }
        
        return secondLargest;
    }

}
