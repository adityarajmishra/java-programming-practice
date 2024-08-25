import java.util.*;

public class Main {
    public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
        
            int n = sc.nextInt();
            
            String str = sc.nextLine();
            String[] strs = new String[n];
            for(int i=0;i<n;i++)strs[i]=sc.next();
            List<List<String>> list = groupAnagrams(strs);
             list.sort((list1, list2) -> list1.get(0).compareTo(list2.get(0)));
            
                System.out.println(list);
           
        
        sc.close();
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

	        // write code here
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            // Convert the string to a char array, sort it, and then convert it back to a string
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);

            // If the sorted string is not in the map, add it with a new list
            if (!anagramMap.containsKey(sortedStr)) {
                anagramMap.put(sortedStr, new ArrayList<>());
            }

            // Add the original string to the list corresponding to the sorted string
            anagramMap.get(sortedStr).add(str);
        }

        // Convert the map values to a list of lists
        return new ArrayList<>(anagramMap.values());
    }
}


Explanation:
Sorting the Characters: For each string in the input array, convert it into a character array, sort the characters, and then convert it back to a string. This sorted string will serve as the key in our HashMap.

HashMap to Group Anagrams: The HashMap stores the sorted string as the key and a list of original strings that correspond to this sorted key as the value. This way, all anagrams end up in the same list.

Collecting the Results: After processing all strings, the values of the HashMap are collected into a list of lists, which contains the grouped anagrams.

Sorting the Groups: To match the expected output, the list of lists is sorted based on the first element of each list.

Example Walkthrough:
For input eat tea tan ate nat bat, the sorted versions of the strings are aet, aet, ant, aet, ant, and abt. The map groups these as follows:
Key aet: List [eat, tea, ate]
Key ant: List [tan, nat]
Key abt: List [bat]
The final output is the grouped anagrams in lexicographical order of their first element.