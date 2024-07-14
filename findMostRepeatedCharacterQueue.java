import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(findMostRepeatedCharacter(input));
        scanner.close();
    }

    public static char findMostRepeatedCharacter(String input) {
        //Write your code here
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("Input string cannot be null or empty");
        }

        // Create a HashMap to store character frequencies
        HashMap<Character, Integer> charCountMap = new HashMap<>();

        // Count the frequency of each character
        for (char c : input.toCharArray()) {
            charCountMap.put(c, charCountMap.getOrDefault(c, 0) + 1);
        }

        // Find the character with the highest frequency
        char mostRepeatedChar = input.charAt(0);
        int maxCount = 0;

        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostRepeatedChar = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostRepeatedChar;

        
    }
}

// public static char findMostRepeatedCharacter(String input) {
//         //Write your code here
//         Map<Character, Integer> mymap = new HashMap<>();

//         // example
//         for(int i=0;i<input.length();i++) {
//             // Character is not present in the map
//             if(!mymap.containsKey(input.charAt(i))) {
//                 mymap.put(input.charAt(i), 1);
//             } else {
//                 // character is already present in the map
//                 // e -> 1
//                 // e -> 1+1 = 2
//                 char val = input.charAt(i);
//                 mymap.put(val, mymap.get(val) + 1);
//             }
//         }

//         int maximumValue = Integer.MIN_VALUE;
//         Character result = ' ';
//         for(char val: mymap.keySet()) {
//             int frequency = mymap.get(val);
//             if(frequency > maximumValue) {
//                 maximumValue = frequency;
//                 result = val;
//             }
//         }
//         return result;
        
//     }