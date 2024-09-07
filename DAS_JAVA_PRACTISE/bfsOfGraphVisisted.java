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
        ArrayList<Integer> ans = bfsOfGraph(v,adj);
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

            }

            
            return adjList;
        }

		
   public static ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {

     //write your code here
    ArrayList<Integer> bfsTraversal = new ArrayList<>();
    boolean[] visited = new boolean[V];
    Queue<Integer> queue = new LinkedList<>();
    
    queue.add(0);
    visited[0] = true;

    while (!queue.isEmpty()) {
        int node = queue.poll();
        bfsTraversal.add(node);

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                visited[neighbor] = true;
                queue.add(neighbor);
            }
        }
    }

    return bfsTraversal;
    }


  
}

