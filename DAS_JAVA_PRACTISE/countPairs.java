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
         System.out.println(countPairs(arr,n,k));
         
     }
     
     public static int countPairs(int[] arr, int N, int K){
          // write your code here
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int count = 0;

        for(int i = 0; i < N; i++){
            int complement = K - arr[i];
            if(frequencyMap.containsKey(complement)){
                count += frequencyMap.get(complement);
            }
            frequencyMap.put(arr[i], frequencyMap.getOrDefault(arr[i], 0) + 1);
        }

        return count;
     }

}
