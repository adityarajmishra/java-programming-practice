import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        int k = sc.nextInt();
    
        System.out.println(painting_challenge(n, k));
    }
    
    public static long painting_challenge(int n, int k){
        //write your code here
        // Create a 2D array to use as a dynamic programming table
        // dp[i][0] represents the number of ways to paint the fence up to post i
        // without repeating colors on the last two posts
        // dp[i][1] represents the number of ways to paint the fence up to post i
        // with the same color on the last two posts
        int[][] dp = new int[n][2];
      
        // Base case initialization:
        // There are k ways to paint the first post (since it has no previous post to consider)
        dp[0][0] = k;
      
        // Iterate over the fence posts starting from the second post
        for (int i = 1; i < n; ++i) {
            // Calculate the number of ways to paint the current post without repeating colors
            // This is done by multiplying the total number of ways to paint the previous post
            // by (k - 1), since we can choose any color except the one used on the last post
            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) * (k - 1);
          
            // Calculate the number of ways to paint the current post using the same color
            // as the last post. This can only be done if the last two posts have different colors,
            // so we use the value from dp[i - 1][0].
            dp[i][1] = dp[i - 1][0];
        }
      
        // Return the total number of ways to paint the entire fence with n posts by summing
        // the ways to paint with the same color and with different colors on the last two posts
        return dp[n - 1][0] + dp[n - 1][1];
    }
}


Solution Approach
The given solution implements the intuition using a dynamic programming (DP) approach. The essential components of this solution are:

Data Structure: A 2D list dp with n rows and 2 columns, used to store the number of ways to paint up to the current post. Here, n is the number of fence posts. The first column (dp[i][0]) stores the number of ways if the last two posts have different colors, and the second column (dp[i][1]) stores the number if they are the same.

Initialization: The DP table is initialized with dp[0][0] = k, representing the k ways to paint the first fence. Since there is no post before the first one, we don't need to initialize dp[0][1] as it is not applicable.

Iteration: The code iterates over each post from 1 to n-1. For each post, the following calculations are performed:

dp[i][0] = (dp[i - 1][0] + dp[i - 1][1]) * (k - 1): The last two posts can be either different or the same, but the current post must be a different color than the last one, hence (k - 1) choices.
dp[i][1] = dp[i - 1][0]: The last two posts must be of different colors for the current post to have the same color as the last one. There is exactly one way to paint it, which is the same color as the previous post.
Final Calculation: After filling the DP table up to n posts, the total ways to paint the fence can be found by adding the values of the last row of the DP table: sum(dp[-1]). This is because the final post can either be painted the same or a different color from the one before it, and we are interested in all possible valid combinations.

The core of this algorithm lies in understanding the constraints and how they impact the subsequences and the transitions between states in the dynamic programming table. This solution maintains constant space complexity for each post with respect to the number of colors, making the overall space complexity O(n). The time complexity is O(n) as well because we compute the entries of the DP table with constant time operations for each of the n posts.

The final result is returned by summing the two scenarios in the last row, which provides the count of all the ways to paint the fence according to the rules.

Let's walk through an example to illustrate the solution approach using the given problem and intuition. Suppose we have n = 3 posts to paint and k = 2 different colors. We want to find out how many ways we can paint the fence.

We initialize a DP table dp with dimensions [n][2] where n is the number of fence posts. Each entry dp[i][0] will store ways we can paint up to the i-th post with the last two posts having different colors, and dp[i][1] will store ways with the last two posts having the same color.

Step 1: Initialization

For the first fence post (i = 0), we have k options, assuming k is not zero. So, dp[0][0] = k since there is no previous post, and the condition for dp[0][1] is not applicable.

For k = 2, the initialization would be dp[0][0] = 2 (we have 2 ways to paint the first post as there are 2 colors).

Step 2: Iteration for the second post

Now, let's move to the second post i = 1. We have two scenarios:

dp[1][0] = (dp[0][0] + dp[0][1]) * (k - 1) since we can paint the second post with a different color than the first in k - 1 ways. Here, dp[0][1] can be considered 0 because it's not applicable. So, dp[1][0] = (2 + 0) * (2 - 1) = 2.
dp[1][1] = dp[0][0] since the last two posts can be the same if the first post was unique, which is already counted in dp[0][0]. Therefore, dp[1][1] = 2.
At this point, our DP table for i = 1 looks like this:

dp = [
  [2, X],  // X denotes non-applicable
  [2, 2],
]
Step 3: Iteration for the third post

For the third post i = 2, we follow a similar procedure:

dp[2][0] = (dp[1][0] + dp[1][1]) * (k - 1) which translates to (2 + 2) * (2 - 1) = 4. We have 4 ways to paint the third post with a different color than the second post.
dp[2][1] = dp[1][0] since again, the last two can be the same only if the previous two were different. So we take the value from dp[1][0] which is 2, giving us dp[2][1] = 2.
Now, our DP table for i = 2 looks like this:

dp = [
  [2, X], 
  [2, 2],
  [4, 2],
]
Step 4: Final Calculation

After computing all the values, we want the sum of the last row to get the total number of ways to paint the fence according to the problem's rules. sum(dp[2]) = dp[2][0] + dp[2][1] = 4 + 2 = 6.

Thus, there are 6 different ways to paint the 3 posts using 2 colors while following the given rules. This completes the example walk-through using the dynamic programming solution approach described in the content.