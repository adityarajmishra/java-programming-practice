import java.util.*;

public class Main {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         
         int n = sc.nextInt();
         int m = sc.nextInt();
         int[] arr1 = new int[n];
         int[] arr2 = new int[m];
         
         for(int i=0;i<n;i++){
             arr1[i] = sc.nextInt();
         }
         
         for(int i=0;i<m;i++){
             arr2[i] = sc.nextInt();
         }
         
         ArrayList<Integer> res = findUnion(arr1, arr2, n, m);
         
	  for(Integer i: res)System.out.print(i+" ");
		
		System.out.println();
     }
     
     public static ArrayList<Integer> findUnion(int[] arr1, int[] arr2, int n, int m){
          // write your code here
        Set<Integer> set = new HashSet<>();
        
        // Add all elements of arr1 to the set
        for (int i = 0; i < n; i++) {
            set.add(arr1[i]);
        }
        
        // Add all elements of arr2 to the set
        for (int i = 0; i < m; i++) {
            set.add(arr2[i]);
        }
        
        // Convert set to list and sort it
        ArrayList<Integer> result = new ArrayList<>(set);
        Collections.sort(result);
        
        return result;
    }

}
