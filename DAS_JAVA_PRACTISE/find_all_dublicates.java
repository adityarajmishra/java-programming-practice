import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
	    int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
	
       find_all_dublicates(n,arr);    
        
         
	
    }
    public static void find_all_dublicates(int n, int[] arr){
		//write your code here
        Set<Integer> seen = new HashSet<>();
        TreeSet<Integer> duplicates = new TreeSet<>();
        
        for (int i = 0; i < n; i++) {
            if (!seen.add(arr[i])) {
                duplicates.add(arr[i]);
            }
        }
        
        for (int num : duplicates) {
            System.out.print(num + " ");
        }
    }
}


Explanation:
HashSet seen: This is used to track elements as we iterate through the array. The add method of HashSet returns false if the element is already present in the set, which indicates a duplicate.

TreeSet duplicates: This automatically sorts elements as they are added. When a duplicate is found, it is added to this set.

Iterating and checking duplicates: As you iterate through the array, if the current element is already in the seen set, it's added to the duplicates set.

Output: Finally, the contents of the duplicates set are printed, which gives the duplicates in sorted order.


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
    
       find_all_dublicates(n,arr);    
        
         
    
    }
    public static void find_all_dublicates(int n, int[] arr){
        //write your code here
        List<Integer> duplicates = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int index = Math.abs(arr[i]) - 1;
            if (arr[index] < 0) {
                duplicates.add(Math.abs(arr[i]));
            } else {
                arr[index] = -arr[index];
            }
        }
        
        Collections.sort(duplicates);
        
        for (int num : duplicates) {
            System.out.print(num + " ");
        }
    }
}
