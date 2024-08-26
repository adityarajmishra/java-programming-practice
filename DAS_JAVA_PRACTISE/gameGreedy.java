import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
	
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[n];
	    for(int i=0;i<n;i++){
		    arr[i]=sc.nextInt();
        }
        System.out.println(game(n,arr));
    }
    public static boolean game(int n,int[] arr){
        //write your code here
        int maxReach = 0;
        for(int i = 0; i < n; i++) {
            if(i > maxReach) {
                return false;  // If the current index is beyond the max reachable point
            }
            maxReach = Math.max(maxReach, i + arr[i]);
            if(maxReach >= n - 1) {
                return true;  // If we can reach or exceed the last index
            }
        }
        return false;
    }

}


Explanation:
maxReach: This variable keeps track of the farthest index that can be reached at any point during the iteration.
Loop: We iterate through each index i:
If i is greater than maxReach, it means we're stuck and cannot move further, so we return false.
We update maxReach with the farthest index we can reach from the current index (i + arr[i]).
If at any point maxReach is greater than or equal to n-1 (the last index), we can reach the end, so we return true.
This approach runs in O(n) time, making it efficient for large arrays.