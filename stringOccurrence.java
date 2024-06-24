import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.next();
        String ans = findRepeated(n);
        System.out.println(ans);
    }


    private static String findRepeated(String s) {
        // Write your code here
        Set<Character> seen = new HashSet<>();
        for (char c : s.toCharArray()) {
            if (seen.contains(c)) {
                return Character.toString(c);
            }
            seen.add(c);
        }
        return "";  // In case there is no repeated character, though problem guarantees there will be one
    }

}