import java.util.*;

class Main {
        
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] grid = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                grid[i][j]=scanner.nextInt();
            }
        }

        System.out.println(numIslands(grid));

    }
    public static  int numIslands(int[][] grid)
    {
        // write your code here
         if (grid == null || grid.length == 0) {
            return 0;
        }

        int rows = grid.length;
        int cols = grid[0].length;
        int answer = 0;
        boolean[][] visited = new boolean[rows][cols]; // No need to initialize anything specific

        // Traverse through the grid to find unvisited land cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // If it's land and not visited, trigger BFS
                if (grid[i][j] == 1 && !visited[i][j]) {
                    breadthFirstSearch(grid, i, j, visited);
                    answer++; // Increment island count after each BFS
                }
            }
        }
        return answer;
    }

    public static void breadthFirstSearch(int[][] grid, int i, int j, boolean[][] visited) {
        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        visited[i][j] = true; // Mark the starting point as visited

        // Define the four possible directions (up, down, left, right)
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        // Perform BFS
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int row = cell[0];
            int col = cell[1];

            // Explore all neighboring cells
            for (int[] direction : directions) {
                int newRow = row + direction[0];
                int newCol = col + direction[1];

                // Check if the new cell is within bounds, is land (1), and not visited
                if (newRow >= 0 && newCol >= 0 && newRow < rows && newCol < cols &&
                    !visited[newRow][newCol] && grid[newRow][newCol] == 1) {
                    queue.add(new int[]{newRow, newCol});
                    visited[newRow][newCol] = true; // Mark it as visited
                }
            }
        }
    }
  
}
