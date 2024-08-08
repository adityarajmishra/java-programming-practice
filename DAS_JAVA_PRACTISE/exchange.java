import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] alice = new int[n];

        for (int i = 0; i < n; i++) {
            alice[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] bob = new int[m];

        for (int j = 0; j < m; j++) {
            bob[j] = sc.nextInt();
        }
        for (int i : exchange(n, m, alice, bob)) {
            System.out.print(i + " ");
        }
    }

    public static int[] exchange(int n, int m, int[] alice, int[] bob) {
        quickSort(alice, 0, n - 1);
        quickSort(bob, 0, m - 1);

        int medianAlice = findMedian(alice);
        int medianBob = findMedian(bob);

        return new int[]{medianAlice, medianBob};
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static int findMedian(int[] arr) {
        int length = arr.length;
        if (length % 2 == 0){
            return arr[(length) / 2];
        }else{
            return arr[(length - 1) / 2];
        }
        
    }
}