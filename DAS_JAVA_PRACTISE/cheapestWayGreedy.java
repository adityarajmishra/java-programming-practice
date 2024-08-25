import java.util.*;

public class Main {
    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        int[] cost = new int[n];
        for(int i=0; i<n; i++)cost[i] = sc.nextInt();

        System.out.println(cheapestWay(n,cost));
    }
    
    public static int cheapestWay(int n, int[] cost){
        //write your code here
        int[] minimumCost = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            int takeStepOne = minimumCost[i - 1] + cost[i - 1];
            int takeStepTwo = minimumCost[i - 2] + cost[i - 2];
            minimumCost[i] = Math.min(takeStepOne, takeStepTwo);
        }
        
        return minimumCost[n];
    }

}
