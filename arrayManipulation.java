import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String inputLine = sc.nextLine();

        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(inputLine);

        if (matcher.find()) {
            String numbers = matcher.group(1);
            String[] stringValues = numbers.split(",");

            int[] intValues = new int[stringValues.length];

            for (int i = 0; i < stringValues.length; i++) {
                try {
                    intValues[i] = Integer.parseInt(stringValues[i].trim());
                } catch (NumberFormatException e) {
                    System.out.println("Invalid integer input: " + stringValues[i].trim());
                    return;
                }
            }
            processArray(intValues); // This function now just modifies the print statements
        } else {
            System.out.println("Invalid input format. Please use [1, 2, 3, 4, 5] format.");
        }
    }

    public static void processArray(int[] digits) {
        // First array: product of each element with its index
        int[] productArray = new int[digits.length];
        for (int i = 0; i < digits.length; i++) {
            productArray[i] = digits[i] * i;
        }

        // Second array: running sum
        int[] sumArray = new int[digits.length];
        sumArray[0] = digits[0];
        for (int i = 1; i < digits.length; i++) {
            sumArray[i] = sumArray[i - 1] + digits[i];
        }

        // Printing the results
        System.out.println(Arrays.toString(productArray));
        System.out.println(Arrays.toString(sumArray));
    }
}
