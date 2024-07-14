import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        input = input.substring(1, input.length() - 1);  
        String[] strs = input.split(",");  

        for (int i = 0; i < strs.length; i++) {
            strs[i] = strs[i].trim().replaceAll("^\"|\"$", "");
        }

        List<List<String>> result = groupAnagrams(strs);

        System.out.println(result.toString());

        scanner.close();
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // Write your code here
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sorted = new String(charArray);
            
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(s);
        }

        List<List<String>> result = new ArrayList<>(map.values());

        // Sort each list of anagrams to ensure consistent ordering
        for (List<String> list : result) {
            Collections.sort(list);
        }

        // Sort the outer list to ensure the groups are in consistent order
        result.sort((l1, l2) -> l1.get(0).compareTo(l2.get(0)));

        return result;
    }
}
