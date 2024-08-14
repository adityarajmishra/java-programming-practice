import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
	    minimumLength(str);
    }
    public static void minimumLength(String str){
		//write your code here
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char current = str.charAt(i);

            if (!stack.isEmpty()) {
                char top = stack.peek();
                if ((top == 'A' && current == 'B') || (top == 'C' && current == 'D')) {
                    stack.pop(); // Remove the pair "AB" or "CD"
                } else {
                    stack.push(current); // Push the current character onto the stack
                }
            } else {
                stack.push(current); // Push the current character onto the stack
            }
        }

        System.out.println(stack.size()); // The size of the stack is the length of the reduced string
    }
}


To solve the problem of reducing the string by repeatedly removing the substrings "AB" and "CD" until no more such substrings are present, we can use a stack. The idea is to iterate through the string and use the stack to track the characters. Whenever we find "AB" or "CD", we pop the last characters off the stack.

Approach:
Initialize an empty stack.
Iterate through the string:
If the stack's top is 'A' and the current character is 'B', pop 'A' from the stack (this removes "AB").
If the stack's top is 'C' and the current character is 'D', pop 'C' from the stack (this removes "CD").
Otherwise, push the current character onto the stack.
After processing the string, the remaining stack represents the reduced string.
Output the length of the stack, which is the length of the reduced string.