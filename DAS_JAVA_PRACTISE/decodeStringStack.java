import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(decodeString(str));
    }
    
    public static String decodeString(String str){
		//write your code here
        Stack<String> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        String currentString = "";
        int k = 0;
        
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            
            if (Character.isDigit(ch)) {
                // Building the number (in case it has multiple digits)
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                // Push the current string and current k to their stacks
                countStack.push(k);
                stringStack.push(currentString);
                // Reset currentString and k
                currentString = "";
                k = 0;
            } else if (ch == ']') {
                // Pop a multiplier and the previous string
                int count = countStack.pop();
                StringBuilder decodedString = new StringBuilder(stringStack.pop());
                // Append the currentString count times
                for (int j = 0; j < count; j++) {
                    decodedString.append(currentString);
                }
                // Update currentString to the newly formed string
                currentString = decodedString.toString();
            } else {
                // If it's a letter, add it to currentString
                currentString += ch;
            }
        }
        
        return currentString;
    }
}


To decode the string as described in the problem, you can use a stack to handle the nested decoding and multiplier operations. Here's how to implement the solution in Java:

Approach:
Stacks for Strings and Integers:

Use two stacks: one for storing the strings (stringStack) and another for storing the multipliers (countStack).
Iterate through the string character by character.
Handling Digits:

When a digit is encountered, calculate the full number (which may consist of multiple digits).
Handling [:

When an opening bracket [ is encountered, push the current string (which you were building so far) onto stringStack, and the current multiplier onto countStack. Then, reset the current string to empty.
Handling ]:

When a closing bracket ] is encountered, pop the string from stringStack and the multiplier from countStack. Multiply the current string by the multiplier and append it to the popped string.
Handling Letters:

If a letter is encountered, simply append it to the current string.
Final Output:

At the end, the stack will be empty, and the current string will hold the decoded string.

Explanation:
Character.isDigit(ch): Checks if the character is a digit.
countStack.push(k): Stores the multiplier.
stringStack.push(currentString): Stores the string built so far.
currentString += ch: Appends the letter to the current string.
countStack.pop(): Retrieves the stored multiplier when encountering ].
stringStack.pop(): Retrieves the string before the corresponding [.
Example:
For str = "3[a]2[bc]":

Decoding would result in "aaabcbc".
For str = "3[a2[c]]":

Decoding would result in "accaccacc".
