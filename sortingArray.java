import java.util.*;
public class Main
{
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i =0 ;i<n ;i++){
           arr[i] = sc.nextInt();
        }
        int[] res = solve(arr,n);
        System.out.println(Arrays.toString(res));
        
         
    }
    
    public static int[] solve(int[] arr, int n){
                
	// write the missing code here
        Arrays.sort(arr); // This sorts the array in place
        return arr; // Return the sorted array 
    }
}

