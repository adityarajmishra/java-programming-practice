import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] inputElements = input.replaceAll("[\\[\\]]", "").split(",\\s*");

        int[] array = new int[inputElements.length];
        for (int i = 0; i < inputElements.length; i++) {
            array[i] = Integer.parseInt(inputElements[i]);
        }

        Stack<Integer> stack = pushToStack(array);

        System.out.println(stack.toString());

        scanner.close();
    }

    public static Stack<Integer> pushToStack(int[] array) {
        //Write your code here
        Stack<Integer> stack = new Stack<>();
        // Push each element of the array onto the stack
        for (int num : array) {
            stack.push(num);
        }
        return stack;
        
    }
}