import java.util.*;

public class Main {
    public static void main(String[] args) {
        
            Scanner sc = new Scanner(System.in);    
            int n = sc.nextInt();
            List<Integer> ans = pascalSequence(n);
    
             
               System.out.print(ans);
             

    }
    
    public static List<Integer> pascalSequence(int index){
        //write your code here
       
        List<Integer> prev=new ArrayList<Integer>(Arrays.asList(1));

        for(int i=1; i<=index; i++){
             List<Integer> curr = new ArrayList<>();
            curr.add(1);
            for(int j=1; j<i; j++){
                curr.add( prev.get(j-1) + prev.get(j));
            }
            curr.add(1);
            prev=curr;
        }
        return prev;
    }
}


import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        int n = sc.nextInt();
        List<Integer> ans = pascalSequence(n);
        System.out.print(ans);
    }
    
    public static List<Integer> pascalSequence(int index){
        List<Integer> row = new ArrayList<>();
        
        // The first element is always 1
        row.add(1);
        
        // Calculate the rest of the elements
        for (int i = 1; i <= index; i++) {
            int previous = row.get(i - 1);
            int current = previous * (index - i + 1) / i;
            row.add(current);
        }
        
        return row;
    }
}


To generate a specific row of Pascal's Triangle using dynamic programming, you can follow these steps:

Initialize a list to store the elements of the Pascal's Triangle row.
Use dynamic programming to iteratively calculate each element of the row based on the previous element.
Pascal's Triangle is defined such that the i-th element of a row can be computed using the formula:

row
[
𝑖
]
=
row
[
𝑖
−
1
]
×
index
−
𝑖
+
1
𝑖
row[i]=row[i−1]× 
i
index−i+1
​
 
where index is the row number (0-based index).