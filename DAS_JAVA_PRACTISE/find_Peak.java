import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
	
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        
        
        int[] arr= new int[n];
        
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();	
        }
        System.out.println(find_Peak(arr));	

    }
public static int find_Peak(int[] arr) {
    if (arr == null || arr.length == 0) {
        return -1;
    }
    return find_Peak(arr, 0, arr.length - 1);
}

private static int find_Peak(int[] arr, int left, int right) {
    int mid = left + (right - left) / 2;
    
    // Check if mid is a peak element
    boolean isPeak = (mid == 0 || arr[mid] >= arr[mid - 1]) &&
                     (mid == arr.length - 1 || arr[mid] >= arr[mid + 1]);
                     
    if (isPeak) {
        return mid;
    }
    
    // If left neighbor is greater, search in the left half
    if (mid > 0 && arr[mid - 1] > arr[mid]) {
        return find_Peak(arr, left, mid - 1);
    }
    
    // Otherwise, search in the right half
    return find_Peak(arr, mid + 1, right);
}


}
