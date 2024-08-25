import java.util.*;


public class Main {
    // NOTE: Please do not modify this function
   public static void main(String args[] ) throws Exception {
     Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        char[][] board = new char[n][m];
        for(int i=0; i<n; i++){
            String str = sc.next();
            for(int j=0; j<m; j++){
                board[i][j] = str.charAt(j);
            }
        }
        String word= sc.next();
        wordSearch( n, m, board, word);

	}
	public static void wordSearch(int n,int m,char[][] board,String word){
        //write your code only
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (searchFromCell(i, j, 0, board, word, n, m)) {
                    System.out.println("Yes");
                    return;
                }
            }
        }
        System.out.println("No");
    }

    private static boolean searchFromCell(int row, int col, int index, char[][] board, String word, int n, int m) {
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= n || col < 0 || col >= m || board[row][col] != word.charAt(index)) {
            return false;
        }

        char temp = board[row][col];
        board[row][col] = '#'; // Mark as visited

        // Check horizontally and vertically
        boolean found = searchFromCell(row, col + 1, index + 1, board, word, n, m) || // Right
                        searchFromCell(row, col - 1, index + 1, board, word, n, m) || // Left
                        searchFromCell(row + 1, col, index + 1, board, word, n, m) || // Down
                        searchFromCell(row - 1, col, index + 1, board, word, n, m);   // Up

        board[row][col] = temp; // Restore the original character

        return found;
    }
  
}


The wordSearch function iterates through each cell in the grid.
For each cell, it calls searchFromCell to start a depth-first search (DFS) from that cell.
searchFromCell is a recursive function that:

Checks if we've found the entire word (base case for success).
Checks if we're out of bounds or the current cell doesn't match the next letter of the word (base cases for failure).
If the current cell matches, it marks the cell as visited (to avoid using it again in the same word), then recursively checks in all four directions (right, left, down, up).
After the recursive calls, it restores the original character (backtracking).


If any search is successful, we print "Yes" and return. If we've checked all cells and haven't found the word, we print "No".

This implementation adheres to the constraints:

It works for grids up to 6x6 in size.
It handles words up to 15 characters long.
It only considers horizontal and vertical connections.
It assumes all input (board and word) is in uppercase English letters.

The time complexity is O(n * m * 4^L), where n and m are the dimensions of the grid, and L is the length of the word. In the worst case, we might need to explore all four directions for each letter of the word from each starting position.