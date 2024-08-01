import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        convert(n, arr);
    }

    public static void convert(int n, int[] arr) {
        StringBuilder result = new StringBuilder();
        
        for(int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                result.append(0);
            } else {
                result.append(arr[i]);
            }
        }
        
        System.out.println(result.toString());
    }
}
