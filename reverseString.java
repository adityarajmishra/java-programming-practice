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
        // Write your code here 
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();           
    }
}
