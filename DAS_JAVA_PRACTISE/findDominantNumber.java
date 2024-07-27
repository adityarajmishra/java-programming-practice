import java.util.*;

public class Main {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);         
         int n = sc.nextInt();
         int[] arr = new int[n];
                for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                }
         
           
        findDominantNumber(arr,n);
         
     }
     
     public static void findDominantNumber(int[] arr, int N){
          // write your code here
        List<Integer> dominantNumbers = new ArrayList<>();
        int maxFromRight = arr[N - 1];
        dominantNumbers.add(maxFromRight);

        for(int i = N - 2; i >= 0; i--){
            if(arr[i] >= maxFromRight){
                maxFromRight = arr[i];
                dominantNumbers.add(maxFromRight);
            }
        }

        Collections.reverse(dominantNumbers);
        for(int num : dominantNumbers){
            System.out.print(num + " ");
        }
     }


}

