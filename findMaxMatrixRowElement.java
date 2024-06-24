import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        
      int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        findMax(matrix,rows,cols);
    }

    public static void findMax(int[][] matrix,int rows, int cols) {
       //Write your code here
        for (int i = 0; i < rows; i++) {
            int maxInRow = matrix[i][0]; // Initialize max with the first element of the row
            for (int j = 1; j < cols; j++) {
                if (matrix[i][j] > maxInRow) {
                    maxInRow = matrix[i][j]; // Update max if current element is greater
                }
            }
            System.out.println(maxInRow);
        }
       
    }
}

