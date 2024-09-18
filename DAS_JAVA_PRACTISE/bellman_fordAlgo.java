import java.util.*;
class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int V = scanner.nextInt();
        int E = scanner.nextInt();
        ArrayList<ArrayList<Integer>> edges = new ArrayList<>();
        int c = 0;
        while (c++ < E) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            ArrayList<Integer> al1 = new ArrayList<>();
            al1.add(u);
            al1.add(v);
            al1.add(w);
            edges.add(al1);
        }
        int S = scanner.nextInt();
        int[] ans = bellman_ford(V, edges, S);
        if (ans == null) {
            System.out.print(-1);
        } else {
            for (int i = 0; i < ans.length; i++) {
                System.out.print(ans[i] + " ");
            }
        }
    }

    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Step 1: Initialize distances from source to all vertices as infinite (10^8), except the source itself
        int[] dist = new int[V];
        Arrays.fill(dist, 100000000); // 10^8 as unreachable
        dist[S] = 0; // Distance to the source is 0

        // Step 2: Relax all edges V-1 times
        for (int i = 0; i < V - 1; i++) {
            for (ArrayList<Integer> edge : edges) {
                int u = edge.get(0); // from node
                int v = edge.get(1); // to node
                int weight = edge.get(2); // edge weight

                // Relax the edge if a shorter path is found
                if (dist[u] != 100000000 && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        // Step 3: Check for negative weight cycles
        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);

            // If we can still relax an edge, then there's a negative cycle
            if (dist[u] != 100000000 && dist[u] + weight < dist[v]) {
                return null; // Return null to indicate a negative weight cycle
            }
        }

        return dist; // Return the shortest distance array
    }
}


Based on the image and the problem you are facing with the Bellman-Ford algorithm, I will provide the correct solution that handles both valid distance calculations and the negative cycle detection.

Problem Details (from image):
Given a weighted and directed graph with V vertices and E edges, you need to find the shortest distance of all vertices from the source vertex S.
If a vertex can't be reached from the source, mark its distance as 10^8.
If the graph contains a negative cycle, return an array consisting only of -1.

Explanation:
Initialization:

The distance to all vertices is set to 10^8 (as unreachable).
The distance to the source vertex S is set to 0.
Relaxation:

We perform V-1 iterations of edge relaxation, as per the Bellman-Ford algorithm.
Negative Cycle Detection:

After relaxing edges V-1 times, we check for any further relaxation, which would indicate the presence of a negative weight cycle.
If a negative cycle is found, we return null and print -1.
Edge Cases:

If a vertex cannot be reached from the source, its distance remains 10^8 as expected.
Output:
The function prints distances from the source S for all vertices. If a vertex cannot be reached, it prints 100000000. If a negative cycle is detected, it prints -1.
