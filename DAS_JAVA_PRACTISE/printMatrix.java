import java.util.*;

public class Main {
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
     
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]= scanner.nextInt();
            }
        }
        rotate(matrix);
        printMatrix(matrix);

    }

    public static void printMatrix(int[][] matrix){
        StringBuilder sb = new StringBuilder();
        for(int[] arr:matrix){
            StringBuilder sb1 = new StringBuilder();
            for(int n :arr){
                sb1.append(n).append(" ");
            }
            sb.append(sb1.substring(0,sb1.length()-1)+"\n");
        }
        System.out.println(sb.toString());
    }

   public static void rotate(int[][] matrix) {
        int n = matrix.length;
        
        // Transpose the matrix
        for(int i = 0; i < n; i++) {
            for(int j = i; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;
            }
        }
    }
}

To rotate an 
n×n matrix by 90 degrees clockwise, we can use the following two-step approach:

Transpose the matrix: Swap elements across the main diagonal.
Reverse each row: Reverse the order of elements in each row.

Explanation
Input Reading:

The input is read using Scanner.
We read the size of the matrix 
n and then the elements of the matrix.
Transpose the Matrix:

We loop through each element above the diagonal and swap it with its corresponding element below the diagonal.
This effectively mirrors the matrix across the main diagonal.
Reverse Each Row:

After transposing, we reverse the order of elements in each row to get the final 90-degree rotated matrix.
Printing the Matrix:

We use a StringBuilder to format the matrix output.
Each row's elements are concatenated with a space and appended to the result string.
This approach is efficient with a time complexity of 
O(n2) and works well within the given constraints.
