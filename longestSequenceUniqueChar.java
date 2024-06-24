import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputLine = sc.nextLine();

        int ans = longestSubstring(inputLine);
        System.out.println(ans);
    }

    public static int longestSubstring(String s) {
        // Initialize a set to keep track of unique characters in the current window
        Set<Character> uniqueChars = new HashSet<>();
        
        int left = 0, right = 0;
        int maxLength = 0;
        
        // Use a sliding window approach
        while (right < s.length()) {
            // If the character at the right pointer is not in the set, add it and move the right pointer
            if (!uniqueChars.contains(s.charAt(right))) {
                uniqueChars.add(s.charAt(right));
                right++;
                // Update the maximum length
                maxLength = Math.max(maxLength, right - left);
            } else {
                // If the character at the right pointer is already in the set, remove the leftmost character and move the left pointer
                uniqueChars.remove(s.charAt(left));
                left++;
            }
        }
        
        return maxLength;
    }

}
