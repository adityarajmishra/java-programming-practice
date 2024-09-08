import java.util.*;

class Main {
		
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int[][] isConnected = new int[V][V];
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                isConnected [i][j]=scanner.nextInt();
            }
        }

        System.out.println(numProvinces(isConnected));

    }
    public static  int numProvinces(int[][] isConnected)
    {
        // write your code here
        int V = isConnected.length;  // number of cities (vertices)
        boolean[] visited = new boolean[V];  // to keep track of visited cities
        int provinces = 0;  // number of connected components (provinces)

        for (int i = 0; i < V; i++) {
            // If the city `i` is not visited, perform BFS from that city
            if (!visited[i]) {
                bfs(i, isConnected, visited);
                provinces++;  // one more province found
            }
        }
        
        return provinces;
    }

    public static void bfs(int node, int[][] isConnected, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;  // Mark the starting city as visited

        while (!queue.isEmpty()) {
            int current = queue.poll();  // Get the next city to explore

            // Explore all cities directly connected to the current city
            for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {
                // If the city `neighbor` is connected to `current` and not visited
                if (isConnected[current][neighbor] == 1 && !visited[neighbor]) {
                    queue.add(neighbor);  // Add it to the BFS queue
                    visited[neighbor] = true;  // Mark it as visited
                }
            }
        }
    }

  
}

To solve this problem using Breadth-First Search (BFS), we can treat the graph as an adjacency matrix where isConnected[i][j] == 1 indicates that there is a direct connection between city i and city j. The problem asks to find the number of "provinces," which means the number of connected components in the graph.

Steps to Solve the Problem:
Each row in the adjacency matrix represents a city, and if isConnected[i][j] == 1, city i and city j are directly connected.
We need to traverse the graph using BFS. Each time we find an unvisited city, we start a BFS, and all cities connected to it will belong to the same province.
Once we finish exploring one connected component (or province), we increment the count.
We continue this process until all cities have been visited.
BFS Approach:
Use a queue to implement BFS.
Start from any unvisited node, add it to the queue, mark it as visited, and explore all its neighbors.
Repeat the process for any unvisited node that hasn't been explored yet.
