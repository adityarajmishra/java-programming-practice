import java.util.*;


public class Main {

      public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
	
	    System.out.println(lengthOfLongestSubstring(s));
         
     }
     
     public static int lengthOfLongestSubstring(String s) {
        
        // Create a set to store characters in the current window
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int left = 0;

        // Traverse the string with a sliding window
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If the character is already in the set, move the left pointer
            // until the character can be removed from the set
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the set
            set.add(c);

            // Update the maximum length of the substring
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }


}


Explanation:
Sliding Window Technique: The idea is to maintain a sliding window that contains a substring without any repeating characters. The window expands by moving the right pointer and contracts by moving the left pointer.

Set Data Structure: We use a HashSet to keep track of characters in the current window. If we encounter a repeating character, we shrink the window from the left until the repeating character is removed.

Max Length Calculation: During each iteration, we calculate the length of the current window (right - left + 1) and update maxLength if this length is greater than the previous maximum.

Example Walkthrough:
For input abcabcbb, the substrings without repeating characters are abc, bca, cab, and the longest one is abc, with length 3.
For input bbbbb, the longest substring without repeating characters is b, with length 1.
For input pwwkew, the substrings are pw, wke, and kew, with the longest being wke or kew, both with length 3.
This solution runs in O(n) time, where n is the length of the input string, making it efficient even for long strings.
