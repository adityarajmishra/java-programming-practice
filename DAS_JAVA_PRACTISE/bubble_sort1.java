import java.util.Scanner;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
	
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr= new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        bubble_sort(n,arr);	

        for(int i: arr)System.out.print(i+" ");
        
    }
    public static void bubble_sort(int n,int[] arr){
        //write your code here
    for (int i = 0; i < n - 1; i++) {
        // Track if any swaps were made in this pass
        boolean swapped = false;
        
        // Perform a pass over the array
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j + 1]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                
                // Set the flag to true since a swap was made
                swapped = true;
            }
        }
        
        // If no swaps were made, the array is sorted
        if (!swapped) {
            break;
        }
    }
    }

}
