import java.util.*;

class Main {
		
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sr = scanner.nextInt();
        int sc = scanner.nextInt();
        int newColor = scanner.nextInt();

        int row = scanner.nextInt();
        int col = scanner.nextInt();
        int[][] image = new int[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                image[i][j]=scanner.nextInt();
            }
        }
        String output =  printMatrix(floodFill(image,sr, sc, newColor));
        System.out.println(output);
        

    }

    public static String printMatrix( int[][] matrix){
        StringBuilder sb = new StringBuilder();
        for(int[] arr:matrix){
            StringBuilder sb1 = new StringBuilder();
            for(int n :arr){
                sb1.append(n).append(" ");
            }
            sb.append(sb1.substring(0,sb1.length()-1)+"\n");
        }
        return sb.toString();
    }

    //Please don't modify the above code

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // write your code here
        int oldColor = image[sr][sc];  
        if (oldColor != color) { 
            dfs(image, sr, sc, oldColor, color);
        }
        return image;
    }

    public static void dfs(int[][] image, int r, int c, int oldColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length || image[r][c] != oldColor) {
            return;
        }

        image[r][c] = newColor;

        dfs(image, r - 1, c, oldColor, newColor);
        dfs(image, r + 1, c, oldColor, newColor);
        dfs(image, r, c - 1, oldColor, newColor);
        dfs(image, r, c + 1, oldColor, newColor);
    }

    


  
}


To implement the floodFill function, the task is to recursively or iteratively fill the pixels that are connected 4-directionally (up, down, left, right) and have the same color as the starting pixel (sr, sc). Here's how to achieve that using Depth-First Search (DFS).

Key Steps:
Base Case: If the starting pixel already has the newColor, return the image as no changes are needed.
DFS Traversal: If the starting pixel has a different color, traverse its neighbors (up, down, left, right). If they have the same color as the original pixel, change their color to the newColor and continue the DFS on them.

Explanation:
Input: The starting pixel's coordinates (sr, sc), the newColor, and the image matrix are taken as input.
Flood Fill Logic:
We check if the color of the starting pixel is the same as newColor. If it is, we do nothing.
If it's different, we start a DFS from the starting pixel to explore and change all connected pixels (up, down, left, right) that have the same original color to the newColor.
DFS Traversal: The dfs function recursively checks each direction. If a neighboring pixel has the original color, it changes it to newColor and proceeds recursively to its neighbors.
Output: Once the flood fill is done, the new image matrix is printed.

