import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
   public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
	    int k=sc.nextInt();
        String num = sc.next();
        minimiseDigits(num,k);
    }
    public static void minimiseDigits(String num,int k){
        //write your code here
    Stack<Character> stack = new Stack<>();
    
    for (char digit : num.toCharArray()) {
        while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
            stack.pop();
            k--;
        }
        stack.push(digit);
    }
    
    // If we still need to remove digits
    while (k > 0 && !stack.isEmpty()) {
        stack.pop();
        k--;
    }
    
    // Build the result string
    StringBuilder result = new StringBuilder();
    while (!stack.isEmpty()) {
        result.insert(0, stack.pop());
    }
    
    // Remove leading zeros
    int i = 0;
    while (i < result.length() && result.charAt(i) == '0') {
        i++;
    }
    
    // Print the result
    System.out.println(i == result.length() ? "0" : result.substring(i));
}
}
