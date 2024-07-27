import java.util.*;
public class Main {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);         
         int n = sc.nextInt();
         int d = sc.nextInt();  
         int[] arr = new int[n];
                for(int i=0;i<n;i++){
             arr[i] = sc.nextInt();
         }
        rotateArray(arr,n,d);
        
         
     }
     
     public static void rotateArray(int[] arr, int N, int D){
          // write your code here
        // Handle the case when D >= N
        D = D % N;

        // Create a new array to hold the result
        int[] rotatedArray = new int[N];

        // Copy the elements from the original array to the rotated positions
        for(int i = 0; i < N; i++){
            rotatedArray[i] = arr[(i + D) % N];
        }

        // Print the rotated array
        for(int i = 0; i < N; i++){
            System.out.print(rotatedArray[i] + " ");
        }          
     }

}
