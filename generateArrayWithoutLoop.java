import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); 
        int[] arr = printNos(n);
        System.out.println(Arrays.toString(arr));
    }

    public static int[] printNos(int n) {
        //Write your code here
        if (n <= 0) {
            return new int[0]; // return an empty array if n is non-positive
        } else {
            // Call the helper function to generate the array
            return generateArray(n, 1);
        }
    }

    // Helper function to generate array elements recursively
    private static int[] generateArray(int n, int current) {
        if (current == n) {
            // If current reaches n, return an array with only n
            int[] result = new int[1];
            result[0] = n;
            return result;
        } else {
            // Recursively call generateArray with incremented current
            int[] temp = generateArray(n, current + 1);
            // Create a new array with one additional element
            int[] result = new int[temp.length + 1];
            // Set the first element of result to current
            result[0] = current;
            // Copy elements from temp to result starting from index 1
            System.arraycopy(temp, 0, result, 1, temp.length);
            return result;
        }
    }
}
