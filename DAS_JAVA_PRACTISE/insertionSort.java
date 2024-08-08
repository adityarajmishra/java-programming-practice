import java.util.*;


 public class Main {
    // NOTE: Please do not modify this method
    public static void main(String[] args) {
	
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr= new int[n];
        
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        insertionSort(n,arr);	

        for(int i=0; i<n; i++){
            System.out.print(arr[i]+" ");
        }

    }

    public static void insertionSort(int N, int[] arr){
        //write your code here
        for(int i=1; i<N; i++){
            int key=arr[i];
            int j=i-1;
            while(j>=0 && arr[j]>key){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }
    }

}
