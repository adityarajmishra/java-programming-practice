import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

	    int n = sc.nextInt();
        int m = 3;
	    int[][] houses = new int[n][3];

	    for(int i=0; i<n; i++){
		    for(int j=0; j<3; j++){
	            houses[i][j] = sc.nextInt();
            }
        }
        System.out.println(minCost(n, m, houses));
    }
	
	public static int minCost(int n, int m, int[][] houses){
		//write your code here
    int[][] dp = new int[n][m];
    
    // Base case: cost for the first house
    for (int j = 0; j < m; j++) {
        dp[0][j] = houses[0][j];
    }
    
    // Fill dp array
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < m; j++) {
            dp[i][j] = houses[i][j] + Math.min(
                dp[i-1][(j+1)%m], 
                dp[i-1][(j+2)%m]
            );
        }
    }
    
    // Return minimum cost for the last house
    return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
}
}
