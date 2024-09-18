import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
   public static void main(String args[] ) throws Exception {
       Scanner sc= new Scanner(System.in);
	    String digit=sc.next();

	for(String str: dialPadCombination(digit)){
		System.out.print(str+" ");
    }

}
   public static List<String> dialPadCombination(String digit){
	//write your code here
        // Mapping of digits to corresponding letters
        String[] dialPad = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };
        
        List<String> result = new ArrayList<>();
        
        // Base case: if the input is empty, return an empty list
        if (digit == null || digit.length() == 0) {
            return result;
        }

        // Start the backtracking process
        backtrack(result, digit, dialPad, new StringBuilder(), 0);
        
        // Return the result list, which will already be in lexicographical order
        return result;
    }

    // Backtracking helper function
    private static void backtrack(List<String> result, String digit, String[] dialPad, StringBuilder current, int index) {
        // If we've processed all digits, add the current combination to the result
        if (index == digit.length()) {
            result.add(current.toString());
            return;
        }

        // Get the digit at the current index
        char currentDigit = digit.charAt(index);
        // Fetch the corresponding letters for this digit
        String letters = dialPad[currentDigit - '0'];

        // Iterate over each letter and recurse
        for (char letter : letters.toCharArray()) {
            current.append(letter);               // Choose the letter
            backtrack(result, digit, dialPad, current, index + 1);  // Explore further
            current.deleteCharAt(current.length() - 1);  // Backtrack
        }
    }
}


To solve the problem of generating all possible combinations for a given digit string based on a phone's dial pad, we need to map each digit to its corresponding set of characters (as on a phone's number pad) and then use recursion or backtracking to generate all combinations.

Approach:
Mapping digits to characters: We create a mapping for the digits 2-9 (since 1 and 0 don't correspond to any letters on a dial pad).
Recursive backtracking: For each digit, generate combinations by appending letters corresponding to that digit and recursively process the remaining digits.
Lexicographical order: By default, since we process digits in order and each digit’s letters are in alphabetical order, the result will be lexicographically sorted.

Explanation:
Mapping Digits to Letters:

We map each digit (from 2 to 9) to its corresponding characters using an array dialPad. For example, 2 maps to "abc", 3 maps to "def", and so on.
Recursive Backtracking:

The function backtrack takes the current state (current), processes each character corresponding to the current digit, and moves to the next digit.
When we reach the end of the digit string (index == digit.length()), we add the current combination to the result list.
StringBuilder:

We use a StringBuilder for efficient string manipulation during backtracking, appending characters when exploring a combination and removing them when backtracking.
Lexicographical Order:

Since the digits are processed in order and the characters within each digit are in lexicographical order (e.g., "abc" for 2), the result is generated in lexicographical order by default.