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
         System.out.println(isCycle(v, adj));
        

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

		
    public static boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
         //write your code here
        boolean[] visited = new boolean[V]; 

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (check(i, V, adj, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean check(int curr, int V,  ArrayList<ArrayList<Integer>> adj, boolean[] visited) {
        visited[curr] = true;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {curr,-1});

        while(!queue.isEmpty()){
            int[] pair = queue.poll();
            int node = pair[0];
            int parent = pair[1];

            for(int adjNode : adj.get(node)){
                if(!visited[adjNode]){
                    visited[adjNode]=true;
                    queue.add(new int[] {adjNode, node});
                }else if(parent != adjNode){
                    return true;
                }
            }
        }
        return false;
    }


  
}


To check for cycles in an undirected graph using Depth First Search (DFS) rather than BFS, you can approach the problem as follows:

You need to traverse each node of the graph using DFS.
While traversing, keep track of the parent of the current node, because in an undirected graph, an edge leading back to the parent is valid and not considered a cycle.
If during DFS traversal you encounter an already visited node that is not the parent, it means a cycle exists.


Explanation:
Adjacency List Creation: The adjacency list is created using the createAdjacencyList() method, where edges are bidirectional (since it's an undirected graph).

Cycle Detection with DFS: The isCycle() method iterates through all nodes to ensure that disconnected components are also checked. For each unvisited node, it calls the recursive dfs() function.

The dfs() function performs depth-first traversal from the current node and marks nodes as visited.
It checks all neighbors of the current node:
If the neighbor is unvisited, a recursive DFS is called on it.
If the neighbor is already visited but is not the parent of the current node, this indicates a cycle.
Main Method: The input is taken in the form of number of vertices (v) and number of edges (E), followed by the edges themselves. The adjacency list is constructed, and the isCycle() function is called to detect if a cycle exists in the graph.

Time Complexity:
Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges. This is because every vertex and every edge is processed once in the DFS traversal.
Space Complexity: O(V), due to the recursion stack and the visited array.
