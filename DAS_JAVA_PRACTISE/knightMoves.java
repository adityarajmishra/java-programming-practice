import java.util.*;

public class Main {
    // Possible moves for a knight
    private static final int[][] directions = {
        {-2, -1}, {-1, -2}, {1, -2}, {2, -1},
        {2, 1}, {1, 2}, {-1, 2}, {-2, 1}
    };

    // NOTE: Please do not modify this function
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rowNum = sc.nextInt();
        int colNum = sc.nextInt();
        int N = sc.nextInt();
        
        System.out.println(knightMoves(rowNum, colNum, N));
    }	

    public static int knightMoves(int rowNum, int colNum, int N) {
        // Adjusting 1-based indexing to 0-based
        rowNum--;
        colNum--;

        Set<String> currentLevel = new HashSet<>();
        currentLevel.add(rowNum + "," + colNum);

        for (int step = 0; step < N; step++) {
            Set<String> nextLevel = new HashSet<>();
            for (String position : currentLevel) {
                String[] pos = position.split(",");
                int row = Integer.parseInt(pos[0]);
                int col = Integer.parseInt(pos[1]);

                for (int[] dir : directions) {
                    int newRow = row + dir[0];
                    int newCol = col + dir[1];

                    if (isValid(newRow, newCol)) {
                        nextLevel.add(newRow + "," + newCol);
                    }
                }
            }
            currentLevel = nextLevel;
        }

        // Return the number of distinct positions reachable after N moves
        return currentLevel.size();
    }

    private static boolean isValid(int row, int col) {
        return row >= 0 && row < 10 && col >= 0 && col < 10;
    }
}

Input: The input consists of three space-separated integers: rowNum, colNum, and N.
Output: You need to print a single integer denoting the number of blocks on the chessboard that the knight can be at in exactly N moves.
Given the constraints (N < 10), the problem is to calculate how many distinct squares the knight can reach after exactly N moves.


Explanation:
knightMoves Method: Calculates the number of distinct blocks the knight can reach after exactly N moves.
Set<String> Usage: Tracks all unique positions that the knight can reach at each level (move). The positions are stored as strings in the format "row,col" to ensure uniqueness.
isValid Method: Ensures that the knight's moves are within the bounds of the 10x10 chessboard.
Output:
The program will print the number of distinct positions the knight can be in after exactly N moves.


