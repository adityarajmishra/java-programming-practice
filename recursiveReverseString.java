import java.util.*;
public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        String ans = reverseString(inputLine);
        System.out.println(ans);

    }

    public static String reverseString(String s) {
        if (s.isEmpty()) {
            return s;
        }
        // Recursive call: take the last character and add the reverse of the rest of the string
        return s.charAt(s.length() - 1) + reverseString(s.substring(0, s.length() - 1));
    }
}
