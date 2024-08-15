package Exercises.dsaProblems;

import java.util.*;

public class ShortestDistanceAfterRoadAcc1 {
    static class Pair {
        int node;
        int wt;

        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }
    public static void main(String[] args) {
        int [] ans = shortestDistanceAfterQueries(6, new int[][]{{0,2},{0,3}});
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }
    public static int[] shortestDistanceAfterQueries(int n, int[][] qr) {
        List<Pair>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) adj[i].add(new Pair(i + 1, 1));
        int[] results = new int[qr.length];
        int p = 0;
        for (int[] query : qr) {
            int u = query[0];
            int v = query[1];
            adj[u].add(new Pair(v, 1));
            results[p++] = dijkstra(adj, 0);
        }
        return results;
    }
    static int dijkstra(List<Pair>[] adj, int src) {
        int n = adj.length;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> a.wt - b.wt);
        pq.add(new Pair(src, 0));

        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            int node = p.node;
            int wt = p.wt;

            if (wt > dist[node]) continue;

            for (Pair edge : adj[node]) {
                int curNode = edge.node;
                int curWt = edge.wt;

                if (dist[node] + curWt < dist[curNode]) {
                    dist[curNode] = dist[node] + curWt;
                    pq.add(new Pair(curNode, dist[curNode]));
                }
            }
        }
        return dist[n - 1];
    }
}
