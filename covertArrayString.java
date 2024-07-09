import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        String[] arr = input.replaceAll("[\\[\\]]", "").split(",\\s*");

        ArrayList<String> arrayList = convert(arr);

        System.out.println(arrayList.toString());

        scanner.close();
    }

    public static ArrayList<String> convert(String[] arr) {
        //Write your code here
        return new ArrayList<>(Arrays.asList(arr));
        
    }
}
