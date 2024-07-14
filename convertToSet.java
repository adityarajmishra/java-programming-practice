import java.util.*;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        String[] stringArray = input.replaceAll("[\\[\\]]", "").split(",\\s*");
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (String s : stringArray) {
            arrayList.add(Integer.parseInt(s));
        }

        int ans = convertToSet(arrayList);
        System.out.println(ans);
    }

    public static Integer convertToSet(ArrayList<Integer> arrayList) {
        //Write your code here
        // Convert ArrayList to Set to remove duplicates
        Set<Integer> set = new HashSet<>(arrayList);

        // Return the size of the Set
        return set.size();

        
    }
}
