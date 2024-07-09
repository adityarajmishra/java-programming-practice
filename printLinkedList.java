import java.util.ArrayList;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        String input = scanner.nextLine();
        
        String[] inputElements = input.replaceAll("[\\[\\]]", "").split(",\\s*");
        
        LinkedList<Integer> arrayList = new LinkedList<>();
        for (String str : inputElements) {
            arrayList.add(Integer.parseInt(str));
        }
        
        printLinkedList(arrayList);
        
        scanner.close();
    }

    public static void printLinkedList(LinkedList<Integer> list) {
       //Write your code here
       String result = String.join(" -> ", list.stream()
                                                 .map(String::valueOf)
                                                 .toArray(String[]::new));
        // Print the result
        System.out.println(result);
       
    }
}
