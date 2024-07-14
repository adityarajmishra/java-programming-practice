import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] stringArray = input.replaceAll("[\\[\\]]", "").split(",\\s*");
        int[] array = new int[stringArray.length];
        for (int i = 0; i < stringArray.length; i++) {
            array[i] = Integer.parseInt(stringArray[i]);
        }

        int sum = scanner.nextInt();
        boolean result = hasPairWithSum(array, sum);
        System.out.println(result);
    }

    public static boolean hasPairWithSum(int[] array, int sum) {
        // Using a HashMap to keep track of the numbers and their indices
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < array.length; i++) {
            int complement = sum - array[i];
            if (numMap.containsKey(complement)) {
                return true;
            }
            numMap.put(array[i], i);
        }

        return false;
    }
}
