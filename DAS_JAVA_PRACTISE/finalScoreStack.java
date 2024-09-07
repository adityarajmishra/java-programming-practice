import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            String[] operation = new String[n];
            for(int i=0; i<n; i++){
                operation[i] = sc.next();
            }
		System.out.println(finalScore(n,operation));
    }
    public static int finalScore(int n, String[] operation){
		//write your code here
        Stack<Integer> stack = new Stack<>();
        
        for (String op : operation) {
            switch (op) {
                case "C":
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                    break;
                case "D":
                    if (!stack.isEmpty()) {
                        stack.push(2 * stack.peek());
                    }
                    break;
                case "+":
                    if (stack.size() >= 2) {
                        int top = stack.pop();
                        int newTop = top + stack.peek();
                        stack.push(top);
                        stack.push(newTop);
                    }
                    break;
                default:
                    stack.push(Integer.parseInt(op));
                    break;
            }
        }

        int sum = 0;
        for (int score : stack) {
            sum += score;
        }
        return sum;
    }
}


Explanation:
Stack Usage:

We use a Stack<Integer> to store the scores.
The stack helps to efficiently manage the operations "C", "D", and "+".
Operations:

"C": Remove the last score by popping from the stack.
"D": Push the double of the last score (top of the stack) onto the stack.
"+": Add the last two scores, push this sum onto the stack.
Integer: Convert the string to an integer and push it onto the stack.
Final Calculation:

After processing all operations, the sum of all the elements in the stack is the final score.
Example:
For operation = ["5","-2","4","C","D","9","+","+"]:
The stack changes as follows:
"5" → [5]
"-2" → [5, -2]
"4" → [5, -2, 4]
"C" → [5, -2] (remove last score)
"D" → [5, -2, -4] (double last score)
"9" → [5, -2, -4, 9]
"+" → [5, -2, -4, 9, 5] (sum of last two scores)
"+" → [5, -2, -4, 9, 5, 14] (sum of last two scores)
Final score: 5 + (-2) + (-4) + 9 + 5 + 14 = 27.
The final score after applying all operations is 27.