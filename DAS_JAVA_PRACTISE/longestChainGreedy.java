import java.util.*;


public class Main {
    // NOTE: Please do not modify this function
   public static void main(String args[] ){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] pairs= new int[n][2];
        for(int i=0; i<n; i++){
            for(int j=0; j<2; j++){
                pairs[i][j] = sc.nextInt();
            }
        }
        
        longestChain(pairs);

    }

    public static void longestChain(int[][] pairs){
        Arrays.sort(pairs, (a,b)->a[1]-b[1]);
        int ans=0;
        int current= Integer.MIN_VALUE;
        for(int[] pair: pairs){
            if(pair[0]>current){
            ans++;
            current=pair[1];
            }
        }
        System.out.println(ans + " ");
        
    }

}
