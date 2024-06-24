import java.util.*;

public class Main {
    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        sc.nextLine();

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
            // if (sc.hasNextLine()) {
            //     sc.nex(); // Consume the leftover newline
            // }
        }

        int[][] ans = rotateMatrix(matrix);
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rotateMatrix(int[][] matrix) {
        //Write your code here  
    int rows = matrix.length;
    int cols = matrix[0].length;
    int[][] rotatedMatrix = new int[cols][rows];

    // Transpose the matrix
    for (int i = 0; i < rows; i++) {
        for (int j = 0; j < cols; j++) {
            rotatedMatrix[j][i] = matrix[i][j];
        }
    }

    // Reverse each row to get the final rotated matrix
    for (int i = 0; i < cols; i++) {
        for (int j = 0; j < rows / 2; j++) {
            int temp = rotatedMatrix[i][j];
            rotatedMatrix[i][j] = rotatedMatrix[i][rows - 1 - j];
            rotatedMatrix[i][rows - 1 - j] = temp;
        }
    }

    return rotatedMatrix;      
    }
}
