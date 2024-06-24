import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
	    Scanner sc= new Scanner(System.in);
        String str= sc.next();
	    traverse(str);       	
    }

    public static void traverse(String str){
	    //write your code here
        for (int i = 0; i < str.length(); i++) {
            System.out.println(str.charAt(i));
        }

    }

}
