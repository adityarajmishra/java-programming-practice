import java.util.*;


public class Main {
    // NOTE: Please do not modify this function
   public static void main(String args[] ) throws Exception {
     Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
	    for(int i = 0; i<n; i++){
		    arr[i] = sc.nextInt();
        }
       countElements(n,arr);

	}
	public static void countElements(int n,int[] arr){
        //write your code only here
        // Use a TreeSet to get unique elements and maintain sorted order
        Set<Integer> uniqueElements = new TreeSet<>();
        for (int num : arr) {
            uniqueElements.add(num);
        }

        // If there are fewer than 3 unique elements, no element can satisfy the condition
        if (uniqueElements.size() < 3) {
            System.out.println(0);
            return;
        }

        // Convert the set to a list to easily access elements by index
        List<Integer> sortedUniqueElements = new ArrayList<>(uniqueElements);

        // Minimum and maximum elements in the unique sorted list
        int min = sortedUniqueElements.get(0);
        int max = sortedUniqueElements.get(sortedUniqueElements.size() - 1);

        // Count elements that are strictly between min and max
        int count = 0;
        for (int num : arr) {
            if (num > min && num < max) {
                count++;
            }
        }

        System.out.println(count);
    }
  
}
