package Exercises.DSU;
class DisjointSet {
    private int[] parent;
    private int[] rank; // Used for Union by Rank/size of the tree

    // Constructor to initialize the DSU
    public DisjointSet(int n) {
        parent = new int[n + 1]; // 1-based indexing
        rank = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            parent[i] = i; // Initially, each node is its own parent
            rank[i] = 1;   // Initial rank is 1
        }
    }

    // Find with Path Compression
    public int find(int node) {
        if (parent[node] != node) {
            parent[node] = find(parent[node]); // Path compression
        }
        return parent[node];
    }

    // Union by Rank
    public boolean union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        // If both nodes already have the same root, cycle detected
        if (rootU == rootV) {
            return true; // Cycle found
        }

        // Attach smaller rank tree under higher rank tree
        if (rank[rootU] > rank[rootV]) {
            parent[rootV] = rootU;
        } else if (rank[rootU] < rank[rootV]) {
            parent[rootU] = rootV;
        } else {
            parent[rootV] = rootU;
            rank[rootU]++; // Increase rank only if both are equal
        }

        return false; // No cycle
    }
}

public class FindCycleInGraph {
    public static void main(String[] args) {
        int n = 5; // Number of nodes
        int[][] edges = {{1, 2}, {2, 3}, {2, 4}, {3, 5}, {6,7}}; // Given undirected edges

        DisjointSet dsu = new DisjointSet(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            if (dsu.union(u, v)) {
                System.out.println("Cycle detected at edge: (" + u + ", " + v + ")");
                return;
            }
        }

        System.out.println("No cycle detected in the graph.");
    }
}
