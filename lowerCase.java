import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        String ans = lowerCase(inputLine);
        System.out.println(ans);
    }

    public static String lowerCase(String s) {
        // Write your code here           
        return s.toLowerCase();
    }
}
