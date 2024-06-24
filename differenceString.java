import java.util.*;


public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
	    Scanner sc= new Scanner(System.in);
        String str1= sc.next();
        String str2= sc.next();

	    difference(str1,str2);       	

    }

    public static void difference(String str1,String str2){
	//write your code here
        // Initialize a StringBuilder to store the differences
        StringBuilder diff = new StringBuilder();

        // Find the length of the shortest string
        int minLength = Math.min(str1.length(), str2.length());

        // Iterate through each character of the strings and find the differences
        for (int i = 0; i < minLength; i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                // If characters are different, append the character from str1 to diff
                diff.append(str1.charAt(i));
            }
        }

        // Append remaining characters from the longer string, if any
        if (str1.length() > str2.length()) {
            diff.append(str1.substring(minLength));
        } else if (str2.length() > str1.length()) {
            diff.append(str2.substring(minLength));
        }

        // Print the differences
        System.out.println(diff.toString());
    }

}
