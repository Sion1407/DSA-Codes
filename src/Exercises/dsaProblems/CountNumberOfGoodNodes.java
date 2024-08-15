package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

public class CountNumberOfGoodNodes {
    public static void main(String[] args) {
        System.out.println(countGoodNodes(new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6}}));
    }

    static List<Integer> adj[];
    static boolean vis[];
    static int ans = 0;
    public static int countGoodNodes(int[][] edges) {
        int n = edges.length;
        adj = new ArrayList[n+1];
        for (int i = 0; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i[]  : edges){
            adj[i[0]].add(i[1]);
            adj[i[1]].add(i[0]);
        }
        vis = new boolean[n+1];
        dfs(0);
        return ans;
    }
    private static int dfs(int root){
        int prev = -1;
        boolean eq = true;
        int size = 0;vis[root] = true;
        for (int i : adj[root]){
            if (vis[i]) continue;
            int temp = dfs(i);
            size += temp+1;
            if (prev==-1 || prev==temp) prev = temp;
            else eq = false;
        }
        if (eq) ans++;
        return size;
    }
}
