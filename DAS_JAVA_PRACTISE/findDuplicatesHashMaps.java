import java.util.*;

public class Main {
      public static void main(String[] args){
         Scanner sc = new Scanner(System.in);
         
         int N = sc.nextInt();
         int[] array = new int[N];
         for(int i=0;i<N;i++){
             array[i] = sc.nextInt();
         }
          ArrayList<Integer> res = findDuplicates(array,N);
         System.out.println(printArrayList(res));
         
     }
     
     public static  ArrayList<Integer> findDuplicates(int[] array, int N){
          // write your code here
                  HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        // Count the frequency of each element
        for (int i = 0; i < N; i++) {
            frequencyMap.put(array[i], frequencyMap.getOrDefault(array[i], 0) + 1);
        }

        // Collect elements that appear more than once
        for (int key : frequencyMap.keySet()) {
            if (frequencyMap.get(key) > 1) {
                result.add(key);
            }
        }

        // If no duplicates were found, return -1
        if (result.isEmpty()) {
            result.add(-1);
        } else {
            // Sort the result to get elements in ascending order
            Collections.sort(result);
        }

        return result;
     }

    public  static  String printArrayList(ArrayList<Integer> arrayList){
      
        StringBuilder sb = new StringBuilder();


        for(int i:arrayList)sb.append(i+" ");


        String result = sb.toString();

        result=result.substring(0,result.length()-1);

        return  result;
    }


}
