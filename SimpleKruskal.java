import java.util.Scanner;

class Edge {
    int src, dest, weight;
}

public class SimpleKruskal {

    // Find the parent of a node
    static int find(int parent[], int i) {
        while (parent[i] != i)
            i = parent[i];
        return i;
    }

    // Union of two sets
    static void union(int parent[], int x, int y) {
        int xset = find(parent, x);
        int yset = find(parent, y);
        parent[xset] = yset;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vertices: ");
        int V = sc.nextInt();

        System.out.print("Enter number of edges: ");
        int E = sc.nextInt();

        Edge[] edges = new Edge[E];

        System.out.println("Enter edges as: src dest weight");
        for (int i = 0; i < E; i++) {
            edges[i] = new Edge();
            edges[i].src = sc.nextInt();
            edges[i].dest = sc.nextInt();
            edges[i].weight = sc.nextInt();
        }

        // Sort edges by weight (bubble sort for simplicity)
        for (int i = 0; i < E - 1; i++) {
            for (int j = 0; j < E - i - 1; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    Edge temp = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = temp;
                }
            }
        }

        int[] parent = new int[V];
        for (int i = 0; i < V; i++)
            parent[i] = i;

        System.out.println("Edges in Minimum Spanning Tree:");
        int totalWeight = 0;
        int count = 0;

        for (int i = 0; i < E && count < V - 1; i++) {
            int u = find(parent, edges[i].src);
            int v = find(parent, edges[i].dest);

            if (u != v) {
                System.out.println(edges[i].src + " -- " + edges[i].dest + " == " + edges[i].weight);
                totalWeight += edges[i].weight;
                union(parent, u, v);
                count++;
            }
        }

        System.out.println("Total weight of MST: " + totalWeight);
        sc.close();
    }
}
