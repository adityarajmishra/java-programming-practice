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
        //Write your code here
        Set<Integer> seenNumbers = new HashSet<>();
        for (int number : array) {
            int complement = sum - number;
            if (seenNumbers.contains(complement)) {
                return true;
            }
            seenNumbers.add(number);
        }
        return false;

        
    }
}
