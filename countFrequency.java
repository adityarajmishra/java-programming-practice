import java.util.ArrayList;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] inputElements = input.replaceAll("[\\[\\]]", "").split(",\\s*");

        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String str : inputElements) {
            arrayList.add(Integer.parseInt(str));
        }

        int element = scanner.nextInt();

        int frequency = countFrequency(arrayList, element);

        System.out.println(frequency);

        scanner.close();
    }

    public static int countFrequency(ArrayList<Integer> list, int element) {
        //Write your code here
        int count = 0;

        // Loop through the list and count occurrences of the element
        for (int num : list) {
            if (num == element) {
                count++;
            }
        }

        // Return the frequency count
        return count;
        
    }
}
