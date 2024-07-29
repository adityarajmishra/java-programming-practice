import java.util.*;

public class Main {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         
         int n = sc.nextInt();
         
         int[] arr = new int[n];
         for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
         }
        int[] res = rearrangeArray(arr);

        for(int i: res)System.out.print(i+" ");
         
     }
     
     public static int[] rearrangeArray(int[] arr){
          // write your code here
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        
        for (int num : arr) {
            if (num >= 0) {
                pos.add(num);
            } else {
                neg.add(num);
            }
        }
        
        int[] result = new int[arr.length];
        int i = 0, j = 0, k = 0;
        
        while (i < pos.size() && j < neg.size()) {
            result[k++] = pos.get(i++);
            result[k++] = neg.get(j++);
        }
        
        while (i < pos.size()) {
            result[k++] = pos.get(i++);
        }
        
        while (j < neg.size()) {
            result[k++] = neg.get(j++);
        }
        
        return result;
    }

}


To rearrange the array such that positive and negative numbers alternate, we can use the following approach:

Separate the positive and negative numbers into two different lists.
Merge the two lists back into one array by alternating between elements from each list.
This ensures that we maintain the relative order of positive and negative numbers while rearranging them alternately.

Explanation:
Input Reading:

The main method reads the input array size n and the elements of the array.
Separation of Positive and Negative Numbers:

Two lists pos and neg are used to store positive and negative numbers separately.
Rearranging Alternately:

A new result array is created.
We merge elements from pos and neg into the result array, alternating between them.
If one of the lists is exhausted before the other, the remaining elements from the other list are added to the result array.