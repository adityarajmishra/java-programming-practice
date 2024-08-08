import java.util.*;


 public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
	
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr= new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        searchRange(n,arr,k);	

    }

    public static void searchRange(int N, int[] arr, int K){
        //write your code here
        int start = findFirstOccurrence(arr, K);
        int end = findLastOccurrence(arr, K);
        
        System.out.println(start + " " + end);
    }

    private static int findFirstOccurrence(int[] arr, int K) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == K) {
                result = mid;
                right = mid - 1; // Keep searching in the left half
            } else if (arr[mid] < K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }

    private static int findLastOccurrence(int[] arr, int K) {
        int left = 0, right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == K) {
                result = mid;
                left = mid + 1; // Keep searching in the right half
            } else if (arr[mid] < K) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }

}
