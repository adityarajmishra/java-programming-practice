import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] inputElements = input.replaceAll("[\\[\\]]", "").split(",\\s*");

        LinkedList<Integer> linkedList = new LinkedList<>();
        for (String str : inputElements) {
            linkedList.add(Integer.parseInt(str));
        }

        int element = scanner.nextInt();

        LinkedList<Integer> updatedList = removeElement(linkedList, element);

        System.out.println(updatedList.toString());

        scanner.close();
    }

    public static LinkedList<Integer> removeElement(LinkedList<Integer> list, int element) {
        //Write your code here
        list.removeFirstOccurrence(element);
        return list;
        
    }
}
