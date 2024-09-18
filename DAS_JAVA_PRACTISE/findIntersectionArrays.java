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
         
         int res[] = findIntersection(arr1, arr2, n, m);
 	     for(int i: res){
              System.out.print(i+" ");
          }
        
    }

    public static int[] findIntersection(int[] arr1, int[] arr2, int n, int m){
        // write your code here
    Set<Integer> set = new HashSet<>();
    Set<Integer> intersectionSet = new HashSet<>();
    
    // Add all elements of arr1 to the set
    for (int num : arr1) {
        set.add(num);
    }
    
    // Check for common elements in arr2
    for (int num : arr2) {
        if (set.contains(num)) {
            intersectionSet.add(num);
        }
    }
    
    // Convert set to array
    int[] result = new int[intersectionSet.size()];
    int index = 0;
    for (int num : intersectionSet) {
        result[index++] = num;
    }
    
    // Sort the result array
    Arrays.sort(result);
    
    return result;
}

}
