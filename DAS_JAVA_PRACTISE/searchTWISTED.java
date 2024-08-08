import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
	
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        int key=sc.nextInt();
        int[] arr= new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
            search(n,arr,key);


    }
    public static void search(int N, int[] arr, int K){
        //write your code here
        int left = 0;
        int right = N-1;
        int ans = -1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if (arr[mid] == K){
                ans = mid;
                break;
            }
            if (arr[mid] > arr[left]){
                if(K >= arr[left] && K < arr[mid]){
                    right = mid -1;
                }else{
                    left = mid+1;
                }
            }else{
                if(K > arr[mid] && K <= arr[right]){
                    left = mid + 1;
                }else{
                    right = mid -1;
                }
            }
        }
        System.out.print(ans + " ");
    }

}
