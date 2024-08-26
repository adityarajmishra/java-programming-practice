import java.util.*;

public class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in); 
        int n = sc.nextInt();
        System.out.println(perfect_square(n));
    }
    
    public static int perfect_square(int n){
        //write your code here
        int[] temp = new int[n+1];
        int maxSquaredIndex = (int) Math.sqrt(n) + 1;
        int[] squareNums = new int[maxSquaredIndex];
        Arrays.fill(temp, Integer.MAX_VALUE);
        temp[0] = 0;

        for(int i = 1; i<maxSquaredIndex; i++){
            squareNums[i] = i * i;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<maxSquaredIndex; j++){
                if(i<squareNums[j]){
                    break;
                }
                temp[i] = Math.min(temp[i] , temp[i-squareNums[j]]+1);
            }
        }
        return temp[n];

    }
}
