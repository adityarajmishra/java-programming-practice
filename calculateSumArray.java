import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
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
 	    int[] ans = calculateSum(intValues);
        System.out.println(Arrays.toString(ans));
           
        } else {
            System.out.println("Invalid input format. Please use [1, 2, 3, 4, 5] format.");
        }
    }

    public static int[] calculateSum(int[] nums) {
        int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            runningSum[i] = runningSum[i - 1] + nums[i];
        }
        return runningSum;
    }

}
