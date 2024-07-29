import java.util.*;

public class Main {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         
         int n = sc.nextInt();
         int[] arr = new int[n];
            for(int i=0;i<n;i++){
             arr[i] = sc.nextInt();
            }
        shiftZeroesToEnd(arr);

        for(int i: arr)System.out.print(i+" ");

        System.out.println();
         
     }
     
     public static void shiftZeroesToEnd(int[] arr){
          // write your code here
        int n = arr.length;
        int nonZeroPosition = 0; // Pointer to place the next non-zero element
        
        // Move all non-zero elements to the front
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[nonZeroPosition] = arr[i];
                nonZeroPosition++;
            }
        }
        
        // Fill the remaining positions with zeroes
        for (int i = nonZeroPosition; i < n; i++) {
            arr[i] = 0;
        }
    }

}
