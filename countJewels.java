import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String jewels = sc.nextLine();
        String stones = sc.nextLine();
        int ans = countJewels(jewels, stones);
        System.out.println(ans);

    }

    public static int countJewels(String jewels, String stones) {
        //Write your code here
        int count = 0;

        // Iterate through each character of the stones string
        for (int i = 0; i < stones.length(); i++) {
            // Check if the character is present in the jewels string
            if (jewels.indexOf(stones.charAt(i)) != -1) {
                // If present, increment the count
                count++;
            }
        }

        return count;

    }
}
