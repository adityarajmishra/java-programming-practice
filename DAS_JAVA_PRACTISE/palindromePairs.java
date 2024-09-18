import java.util.*;

public class Main {
    public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
        int tc = sc.nextInt();
        sc.nextLine(); 
        while (tc-- > 0) {
            int n = sc.nextInt();
            sc.nextLine(); 
            String str = sc.nextLine();
            String[] words = str.trim().split(" ");
            List<List<Integer>> result = palindromePairs(words);
            Collections.sort(result,new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> list1, List<Integer> list2) {
                // Compare lists based on their first element
                int size = Math.min(list1.size(), list2.size());
                for (int i = 0; i < size; i++) {
                    int cmp = list1.get(i).compareTo(list2.get(i));
                    if (cmp != 0) {
                        return cmp;
                    }
                }
                return Integer.compare(list1.size(), list2.size());
            }
        });
                System.out.println(result);
        }
        sc.close();
    }
    
    public static List<List<Integer>> palindromePairs(String[] words) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }

        // Step 1: Create a map to store reversed word and its index
        Map<String, Integer> reversedWordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            reversedWordMap.put(new StringBuilder(words[i]).reverse().toString(), i);
        }

        // Step 2: Check for each word and its possible palindrome pairings
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int wordLength = word.length();

            // Split the word into different prefixes and suffixes
            for (int j = 0; j <= wordLength; j++) {
                String prefix = word.substring(0, j);
                String suffix = word.substring(j);

                // Case 1: Check if prefix is a palindrome and reversed suffix exists in the map
                if (isPalindrome(prefix)) {
                    Integer reversedSuffixIndex = reversedWordMap.get(suffix);
                    if (reversedSuffixIndex != null && reversedSuffixIndex != i) {
                        result.add(Arrays.asList(reversedSuffixIndex, i));
                    }
                }

                // Case 2: Check if suffix is a palindrome and reversed prefix exists in the map
                // Avoid double counting by checking j != wordLength to handle empty suffix
                if (j != wordLength && isPalindrome(suffix)) {
                    Integer reversedPrefixIndex = reversedWordMap.get(prefix);
                    if (reversedPrefixIndex != null && reversedPrefixIndex != i) {
                        result.add(Arrays.asList(i, reversedPrefixIndex));
                    }
                }
            }
        }

        return result;
    }

    // Helper function to check if a string is a palindrome
    private static boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}


To solve the problem of finding palindrome pairs, where two words concatenate to form a palindrome, you can approach it using a HashMap to store reversed words and their indices. Then, for each word, check if any valid palindrome pairs can be formed by splitting the word and searching for corresponding reversed parts in the map.

Approach:
Reverse word matching: Store each word's reversed version and its index in a HashMap.
Prefix and Suffix checking: For each word, try to split it into two parts: prefix and suffix. If either part is a palindrome and the other part exists as a reversed word in the map, then a valid pair is found.
Edge cases:
Handle empty strings.
Avoid self-matching (i.e., a word should not pair with itself unless it's a valid palindrome).

Explanation of Code:
Reversed Word Map: The map reversedWordMap stores each word's reversed version as the key and its index as the value.
Palindrome Check: For each word, it is split into prefix and suffix. If the prefix is a palindrome, we check if the suffix exists as a reversed word in the map and vice versa.
Avoid Self-Pairing: We make sure that a word doesn't pair with itself by checking if the indices are different.
Sorting of Results: After finding all valid pairs, the result is sorted lexicographically based on list comparison.
