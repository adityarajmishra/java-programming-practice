import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
    
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        
        int[] arr= new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int key=sc.nextInt();
        System.out.println(search(n,arr,key));  

    }
public static int search(int n, int[] arr, int key) {
    int left = 0;
    int right = n - 1;

    while (left <= right) {
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == key) {
            return mid;  // Return the index if the key is found
        }
        if (arr[mid] < key) {
            left = mid + 1;  // Search in the right half
        } else {
            right = mid - 1;  // Search in the left half
        }
    }

    // If the key is not found, `left` will be the insertion point
    return left;  
}


}
