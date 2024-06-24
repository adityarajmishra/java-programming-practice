import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
         int n =  sc.nextInt();
         int[] arr = new int[n];
         for(int i=0;i<n;i++)arr[i] = sc.nextInt();
         int[] res = reverseArray(arr);
         System.out.print(Arrays.toString(res));
       
    }

    public static int[] reverseArray(int[] arr) {
        // Write your code here
        int[] reverseArray = new int[arr.length];
        for(int i=1; i<=arr.length; i++){
            reverseArray[i-1]=arr[arr.length-i];
        }
        return reverseArray;
            
    }
}
