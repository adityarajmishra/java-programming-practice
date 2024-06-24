import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputLine = sc.nextLine();
        boolean ans = halvesAreAlike(inputLine);
        if (ans) {
            System.out.println("true");
        }
        else {
            System.out.println("false");
        }


    }

    public static Boolean halvesAreAlike(String s) {
        // Convert the string to lower case to make the comparison case-insensitive
        s = s.toLowerCase();
        int length = s.length();
        int mid = length / 2;
        
        // Get the two halves of the string
        String firstHalf = s.substring(0, mid);
        String secondHalf = s.substring(mid);
        
        // Count vowels in each half
        int firstHalfVowels = countVowels(firstHalf);
        int secondHalfVowels = countVowels(secondHalf);
        
        // Compare the counts of vowels
        return firstHalfVowels == secondHalfVowels;
    }
    
    private static int countVowels(String str) {
        int count = 0;
        for (char ch : str.toCharArray()) {
            if (isVowel(ch)) {
                count++;
            }
        }
        return count;
    }
    
    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
   
}
