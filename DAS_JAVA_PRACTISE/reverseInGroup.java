import java.util.*;

public class Main {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         
         int N = sc.nextInt();
         int K = sc.nextInt();  
         int[] arr = new int[N];
            for(int i=0;i<N;i++){
             arr[i] = sc.nextInt();
            }
        reverseInGroup(arr,N,K);
        for(int i: arr)System.out.print(i+" ");

        System.out.println();
         
     }
     
     public static void reverseInGroup(int[] arr, int N, int K){
          // write your code here
        for (int i = 0; i < N; i += K) {
            int left = i;
            // To handle the case when K is not multiple of N
            int right = Math.min(i + K - 1, N - 1);
            while (left < right) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
        }
    }

}

To reverse elements in groups of size 
K in an array, we need to iterate through the array and reverse each sub-array of size 
K. If the last group has fewer than 
K elements, we reverse all remaining elements.

Explanation:
Input Reading:

The input is read using Scanner.
We read the size of the array 
N and the size of the groups K.
We then read the elements of the array.
Reversing in Groups:

We iterate through the array in steps of K.
For each group, we calculate the left index (start of the group) and the right index (end of the group).
We reverse the elements within this group by swapping elements at the left and right indices and moving towards the center.
Printing the Result:
After reversing the elements in groups, we print the array.