import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        boolean ans = checkPalindrome(inputLine);
        if (ans) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }

    public static Boolean checkPalindrome(String s) {
        // Remove non-alphanumeric characters and convert to lowercase
        String cleaned = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();

        // Use two pointers to check for palindrome
        int left = 0;
        int right = cleaned.length() - 1;

        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
