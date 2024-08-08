import java.util.*;


 public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
	
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        bubbleSort(n,arr);	
        
        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void bubbleSort(int N, int[] arr){
        //write your code here
        for (int i = 0; i < N - 1; i++){
            for(int j = 0; j < N - i - 1; j++){
                if(arr[j]> arr[j+1]){   
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
