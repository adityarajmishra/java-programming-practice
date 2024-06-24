import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt(); 
        int b = sc.nextInt();
        int ans = countBitsFlip(a, b);
        System.out.println(ans);
    }

    public static int countBitsFlip(int A, int B) {
        // XOR of A and B will have set bits only at positions where A and B differ
        int xor = A ^ B;
        int count = 0;

        // Count the number of set bits in the result
        while (xor != 0) {
            xor &= (xor - 1); // This operation reduces the count of set bits by one
            count++;
        }

        return count;
    }
}
