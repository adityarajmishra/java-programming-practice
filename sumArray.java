import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
         int n =  sc.nextInt();
         int[] arr = new int[n];
         for(int i=0;i<n;i++)arr[i] = sc.nextInt();
         System.out.println(sum(arr));
    }

    public static int sum(int[] arr) {
         //write your code here
         int sum = 0;
         for(int i=0; i<arr.length; i++){
             sum = sum + arr[i];
         }
         return sum;
         
     }

}
