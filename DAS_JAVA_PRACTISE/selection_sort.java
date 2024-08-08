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
        arr = selection_sort(n,arr);
        
        for(int i: arr){
            System.out.print(i+" ");
        }   

    }

public static int[] selection_sort(int n, int[] arr) {
    // Perform selection sort
    for (int i = 0; i < n - 1; i++) {
        // Assume the minimum is the current position
        int minIndex = i;
        
        // Find the index of the minimum element in the remaining unsorted portion
        for (int j = i + 1; j < n; j++) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j;
            }
        }
        
        // Swap the found minimum element with the element at index i
        if (minIndex != i) {
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    return arr;
}

}
