import java.util.*;

class Main {
  
public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
         int v = sc.nextInt();
         int E = sc.nextInt();
         int[][] edges = new int[E][2];
         for(int i=0;i<E;i++){
             edges[i][0]=sc.nextInt();
             edges[i][1]=sc.nextInt();
         }
	
 	    ArrayList<ArrayList<Integer>> adj = createAdjacencyList(v, edges);
        ArrayList<Integer> ans = dfsOfGraph(v,adj);
		        System.out.println(ans);

	}
   
   public static ArrayList<ArrayList<Integer>> createAdjacencyList(int V, int[][] edges) {
            ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();

            // Initialize the adjacency list
            for (int i = 0; i < V; i++) {
                adjList.add(new ArrayList<>());
            }

            // Add edges to the adjacency list
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];                
                adjList.get(u).add(v);
                adjList.get(v).add(u);

            }

            
            return adjList;
        }

		
   public static ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

     //write your code here
        boolean[] visited = new boolean[V];  // To keep track of visited nodes
        ArrayList<Integer> result = new ArrayList<>();  // To store DFS traversal order
        
        // Perform DFS starting from node 0
        dfs(0, adj, visited, result);
        
        return result;
    }

    // Helper method for DFS
    public static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> result) {
        visited[node] = true;  // Mark the current node as visited
        result.add(node);      // Add the current node to the result

        // Visit all unvisited adjacent nodes
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, result);
            }
        }
    }


  
}

You are trying to implement a Depth-First Search (DFS) traversal for a graph. The graph is represented by an adjacency list, and you need to write the dfsOfGraph method to perform the DFS traversal starting from node 0 (or any other node, depending on the question). DFS involves visiting nodes recursively and marking them as visited to avoid revisiting them.

Here's how you can implement the dfsOfGraph method:

Steps:
Create a visited array to keep track of visited nodes.
Initialize an empty list result to store the traversal order.
Call the helper function dfs to perform the DFS traversal.
The helper function will recursively visit unvisited adjacent nodes.

