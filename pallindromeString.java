import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();
 
       boolean res = isPalindrome (str);
                System.out.println(res);
    }

    public static boolean isPalindrome(String inputStr) {
        // Write your code here
        StringBuilder normalizedStr = new StringBuilder();
        
        // Normalize the string: remove non-alphanumeric characters and convert to lowercase
        for (int i = 0; i < inputStr.length(); i++) {
            char ch = inputStr.charAt(i);
            if (Character.isLetterOrDigit(ch)) {
                normalizedStr.append(Character.toLowerCase(ch));
            }
        }

        // Check if the normalized string is a palindrome
        String cleanedStr = normalizedStr.toString();
        int left = 0;
        int right = cleanedStr.length() - 1;
        
        while (left < right) {
            if (cleanedStr.charAt(left) != cleanedStr.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
