import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
	
        Scanner sc= new Scanner(System.in);
            int N = sc.nextInt();
            int[] A = new int[N];
            for(int i=0; i<N; i++){
            A[i] = sc.nextInt();
            }
            List<List<Integer>> ans = subsets(N,A);
            ans.sort((list1, list2) -> {
                    // Handle the case where one or both lists are empty
                    if (list1.isEmpty() && list2.isEmpty()) {
                        return 0; // Both lists are empty, considered equal
                    } else if (list1.isEmpty()) {
                        return -1; // Empty list comes first
                    } else if (list2.isEmpty()) {
                        return 1;  // Non-empty list comes after an empty list
                    } else {
                        // Compare by the first element if both lists are non-empty
                        return list1.get(0).compareTo(list2.get(0));
                    }
                });

	   System.out.println(ans);
    }	

    public static List<List<Integer>> subsets(int n, int[] arr){
	       //write your code here
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);  // Ensure the array is sorted
        
        // Generate all possible subsets
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    subset.add(arr[j]);
                }
            }
            result.add(subset);
        }
        
        // Sort the result based on the given criteria
        result.sort((list1, list2) -> {
            if (list1.size() != list2.size()) {
                return Integer.compare(list1.size(), list2.size());
            }
            for (int i = 0; i < list1.size(); i++) {
                int cmp = Integer.compare(list1.get(i), list2.get(i));
                if (cmp != 0) {
                    return cmp;
                }
            }
            return 0;
        });
        
        return result;
    }

}


To generate all possible subsets (also known as the power set) of a given array, you can use a backtracking approach. Here's how you can implement it:

Steps:
Recursive Backtracking: Recursively explore each element, deciding whether to include it in the current subset or not.
Base Case: When you've considered all elements, add the current subset to the result list.
Sorting: After generating all subsets, you can sort them based on the first element (and then by length) as required by the problem.

