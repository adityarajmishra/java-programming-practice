import java.util.*;
class Main{

 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int E = scanner.nextInt();
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
        for(int i=0;i<V;i++)
        {
            adj.add(new ArrayList<ArrayList<Integer>>());
        }
        int c = 0;
        while(c++<E){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            ArrayList<Integer> al1 = new ArrayList<>();
            ArrayList<Integer> al2 = new ArrayList<>();
            al1.add(u);
            al1.add(w);
            al2.add(v);
            al2.add(w);
            adj.get(u).add(al2);
            adj.get(v).add(al1);
        }
        int S = scanner.nextInt();
        int[] ans = dijkstra(V,adj,S);
        for(int i = 0;i<ans.length;i++) {
            System.out.print(ans[i] + " ");
        }
    }
    public static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {

        // Priority queue to select the node with the smallest distance
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        // Distance array initialized to a high value (infinity-like)
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // Set the distance to the source node itself as 0
        dist[S] = 0;
        
        // Push the source node into the priority queue
        pq.add(new int[] { S, 0 });

        // Boolean array to track visited nodes
        boolean[] visited = new boolean[V];

        // Process until the priority queue is empty
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0]; // Node
            int d = current[1]; // Distance

            // If already visited, skip this node
            if (visited[u]) continue;
            visited[u] = true;

            // Process all neighbors of the current node
            for (ArrayList<Integer> neighbor : adj.get(u)) {
                int v = neighbor.get(0); // Neighbor node
                int weight = neighbor.get(1); // Weight of the edge u -> v

                // If we found a shorter path to neighbor v
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[] { v, dist[v] });
                }
            }
        }

        return dist; // Return the array of distances
    }



}

The code you've written is the setup for implementing Dijkstra's algorithm, which finds the shortest path from a source node to all other nodes in a weighted graph. The graph is represented by an adjacency list, where each node has a list of edges along with their weights.

I'll walk you through how to implement the dijkstra function.

Steps for Dijkstra's Algorithm:
Priority Queue: We'll use a priority queue (min-heap) to always expand the node with the smallest known distance.
Distances Array: Maintain an array dist[] where dist[i] represents the minimum distance from the source node S to node i.
Visited Set: Keep track of visited nodes to avoid reprocessing them.
Graph Structure: Each node points to a list of pairs, where each pair represents a neighbor and the weight of the edge to that neighbor.

Explanation:
Adjacency List: We use an adjacency list to store the graph. Each entry in the list contains another list of nodes and the weight of the edge connecting them.
Priority Queue: A priority queue (min-heap) helps to efficiently get the next node with the smallest tentative distance.
Distance Array: The dist[] array keeps track of the minimum distance to each node from the source node S. We initialize all distances to infinity (Integer.MAX_VALUE), except for the source node which is set to 0.
Main Logic: For each node, we explore its neighbors and update the shortest distances if we find a better path. These neighbors are then added to the priority queue for further exploration.


