import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        input = input.replaceAll("[\\[\\]]", ""); 
        String[] elements = input.split(","); 

        Queue<Integer> queue = new LinkedList<>();
        for (String element : elements) {
            queue.add(Integer.parseInt(element.trim()));
        }
        moveFrontToBack(queue);
        System.out.println(queue);
    }

    public static void moveFrontToBack(Queue<Integer> queue) {
        //Write your code here
        if (queue.isEmpty()) {
            return;
        }

        int firstElement = queue.poll();
        queue.add(firstElement);

        
    }
}
