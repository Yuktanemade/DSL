import java.util.*;

class Pair implements Comparable<Pair> {
    int node;
    int weight;

    Pair(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    public int compareTo(Pair other) {
        return this.weight - other.weight;
    }
}

public class PrimsAlgorithmUserInput {

    public static int primsMST(int V, int[][] edges) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // Add edges to the undirected graph
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new Pair(v, wt));
            adj.get(v).add(new Pair(u, wt));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0, 0));  // Start from node 0 with weight 0

        boolean[] visited = new boolean[V];
        int totalWeight = 0;

        while (!pq.isEmpty()) {
            Pair current = pq.poll();
            int u = current.node;
            int wt = current.weight;

            if (visited[u]) continue;

            visited[u] = true;
            totalWeight += wt;

            for (Pair neighbor : adj.get(u)) {
                if (!visited[neighbor.node]) {
                    pq.add(new Pair(neighbor.node, neighbor.weight));
                }
            }
        }

        return totalWeight;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        int[][] edges = new int[E][3];

        System.out.println("Enter edges (u v weight): ");
        for (int i = 0; i < E; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
            edges[i][2] = sc.nextInt();
        }

        int totalCost = primsMST(V, edges);
        System.out.println("Total weight of Minimum Spanning Tree: " + totalCost);
    }
}