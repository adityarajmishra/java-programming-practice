import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char ch = scanner.next().charAt(0);
        scanner.close();

        if (isVowel(ch)) {
            System.out.println("vowel");
        } else if (Character.isLetter(ch)) {
            System.out.println("consonant");
        } else {
            System.out.println(ch + " is not a valid alphabet letter.");
        }
    }

    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch); // Convert character to lowercase for easy comparison
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}