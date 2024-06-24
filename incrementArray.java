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
            int[] array = incrementArray(intValues);
            System.out.println(Arrays.toString(array));


        } else {
            System.out.println("Invalid input format. Please use [1, 2, 3, 4, 5] format.");
        }


    }

    public static int[] incrementArray(int[] digits) {
        // Start from the end of the array and handle carry
        int n = digits.length;
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        // If we are here, it means all the digits were 9
        int[] newDigits = new int[n + 1];
        newDigits[0] = 1;
        return newDigits;
    }
}