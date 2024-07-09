import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] inputElements = input.replaceAll("[\\[\\]]", "").split(",\\s*");

        Stack<Integer> stack = new Stack<>();
        for (String str : inputElements) {
            stack.push(Integer.parseInt(str));
        }

        removeThreeElements(stack);

        System.out.println(stack.toString());

        scanner.close();
    }

    public static void removeThreeElements(Stack<Integer> stack) {
       //Write your code here
        for (int i = 0; i < 3 && !stack.isEmpty(); i++) {
            stack.pop();
        }
       
    }
}
