import java.util.*;

public class BellmanFord {

    // Function to run Bellman-Ford Algorithm
    public static void bellmanFord(int V, int[][] edges, int src) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Relax all edges V - 1 times
        for (int i = 1; i < V; i++) {
            for (int[] edge : edges) {
                int u = edge[0];
                int v = edge[1];
                int wt = edge[2];
                if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                    dist[v] = dist[u] + wt;
                }
            }
        }

        // Check for negative-weight cycles
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];
            if (dist[u] != Integer.MAX_VALUE && dist[u] + wt < dist[v]) {
                System.out.println("Graph contains a negative-weight cycle!");
                return;
            }
        }

        // Print shortest distances
        System.out.println("\nVertex\tDistance from Source");
        for (int i = 0; i < V; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        int[][] edges = new int[E][3];

        System.out.println("Enter edges (u v weight):");
        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();  // u
            edges[i][1] = sc.nextInt();  // v
            edges[i][2] = sc.nextInt();  // weight
        }

        System.out.print("Enter source vertex: ");
        int src = sc.nextInt();

        bellmanFord(V, edges, src);
    }
}