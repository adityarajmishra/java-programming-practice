import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);	
	    int test = sc.nextInt();
	    while(test-->0){
            int n = sc.nextInt();
            int[] house = new int[n];
            for(int i=0; i<n; i++){
                house[i] = sc.nextInt();
            }
            System.out.println(optimalRoute(n,house));
        }
    }
	
	public static int optimalRoute(int n, int[] house){
		//write your code here
        if (n == 0) return 0;
        if (n == 1) return house[0];
        if (n == 2) return Math.max(house[0], house[1]);

        // Case 1: Exclude the last house
        int maxExcludingLast = rob(house, 0, n - 2);

        // Case 2: Exclude the first house
        int maxExcludingFirst = rob(house, 1, n - 1);

        // Return the maximum of the two cases
        return Math.max(maxExcludingLast, maxExcludingFirst);
    }

    public static int rob(int[] house, int start, int end) {
        int n = end - start + 1;
        if (n == 1) return house[start];
        if (n == 2) return Math.max(house[start], house[start + 1]);

        int[] dp = new int[n];
        dp[0] = house[start];
        dp[1] = Math.max(house[start], house[start + 1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + house[start + i]);
        }

        return dp[n - 1];
    }
}
