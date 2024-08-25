import java.util.*;


public class Main {
    // NOTE: Please do not modify this function
   public static void main(String args[] ){
        Scanner sc = new Scanner(System.in);
                int n = sc.nextInt();
                int k = sc.nextInt();
                int[] cost = new int[n]; 
                for(int i=0; i<n; i++){
                    cost[i] = sc.nextInt();
                }
        Arrays.sort(cost);
        System.out.println(findMinimumCost(n,k,cost)+" "+findMaximumCost(n,k,cost));
	}


        public static int findMinimumCost(int n,int k,int[] cost){
            //write your code here
            int res=0;
            for(int i=0; i<n; i++){
                res = res + cost[i];
                n=n-k;
            }
            return res;
        }

        public static int findMaximumCost(int n,int k,int[] cost){
            //write your code here
            int res=0; int index=0;
            for(int i=n-1; i>=index; i--){
                res = res + cost[i];
                index = index+k;
            }
            return res;
        }
}
