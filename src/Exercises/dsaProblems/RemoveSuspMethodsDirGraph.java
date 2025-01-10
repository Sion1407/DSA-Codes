package Exercises.dsaProblems;

import java.util.*;

public class RemoveSuspMethodsDirGraph {
    static List<Integer> adj[];
    public static void main(String[] args) {
        System.out.println(remainingMethods(4,1,new int[][]{{1,2},{0,1},{3,2}}));
    }
    public static List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        adj = new ArrayList[n+1];
        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i[]: invocations) {
            adj[i[0]].add(i[1]);
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> sus = new HashSet<>();
        vis[k] = true;
        sus.add(k);
        q.addAll(adj[k]);
        while (!q.isEmpty()){
            int t = q.poll();
            if (vis[t]) continue;
            sus.add(t);
            vis[t] = true;
            q.addAll(adj[t]);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            res.add(i);
        }
        for (int i = 0; i < vis.length; i++) {
            if (vis[i]) continue;
            q.addAll(adj[i]);
            vis[i] = true;
            while (!q.isEmpty()){
                int t = q.poll();
                if (sus.contains(t))
                    return res;
                if (vis[t]) continue;
                vis[t] = true;
                q.addAll(adj[t]);
            }
        }
        res = new ArrayList<>();
        for (int i = 0 ; i < n; i++) {
            if (sus.contains(i)) continue;
            res.add(i);
        }
        return res;
    }
}
