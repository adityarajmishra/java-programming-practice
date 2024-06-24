import java.util.*;

public class Main{
   
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        for(int i =0 ;i<n ;i++){
           arr1[i] = sc.nextInt();
        }
        for(int i =0 ;i<n ;i++){
           arr2[i] = sc.nextInt();
        }
        
        if(solve(arr1,arr2, n)){
            System.out.println("Equal");
        }else System.out.println("Not Equal");
        
         
    }
    
    public static boolean solve(int[] arr1, int[] arr2, int n){
                
	// write the missing code here
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    return Arrays.equals(arr1, arr2);
    }

}

