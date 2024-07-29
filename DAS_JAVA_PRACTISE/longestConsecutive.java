import java.util.*;

public class Main {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         
         int n = sc.nextInt();
         
         int[] arr = new int[n];
         for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
         }
         int res = longestConsecutive(arr);
         System.out.println(res);
         
     }
     
     public static int longestConsecutive(int[] arr){
          // write your code here
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }

        int maxLength = 0;
        
        for (int num : set) {
            // Check if it is the start of a sequence
            if (!set.contains(num - 1)) {
                int currentNum = num;
                int currentLength = 1;

                while (set.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentLength += 1;
                }

                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }

}


To find the length of the longest consecutive sequence in an array, we can use a set data structure for efficient lookups. The algorithm proceeds as follows:

Convert the array to a set: This allows O(1) time complexity for lookups.
Iterate through the array: For each number, check if it's the start of a sequence by verifying that the number minus one is not in the set.
Count the length of the consecutive sequence: Starting from the current number, count how many consecutive numbers are present in the set.
Update the maximum length: Keep track of the maximum length of consecutive sequences found.

Explanation:
Set Creation:

Convert the array to a set to remove duplicates and allow O(1) time complexity for lookups.
Finding Sequences:

For each number in the set, check if it's the start of a sequence (i.e., num - 1 is not in the set).
If it is the start, count the length of the sequence by continuously checking for the next consecutive number (currentNum + 1).
Updating Maximum Length:

Keep track of the maximum sequence length found during the iteration.