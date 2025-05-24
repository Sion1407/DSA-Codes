package Exercises.graphs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Edge implements Comparable<Edge>{
    int v,e,w;

    Edge(int _v,int _e, int _w){
        this.v = _v;
        this.e = _e;
        this.w = _w;
    }
    public int compareTo(Edge edg){
        return this.w - edg.w;
    }

}
class DisjointSet{
    int [] parent,rank;

    DisjointSet(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i = 0;i < n;i++){
            parent[i] = i;
        }
    }

    public int findUPar(int x){
        if(parent[x]==x){
            return x;
        }
        return findUPar(parent[x]);
    }

    public void unionBySize(int x,int y){
        int nx = findUPar(x);
        int ny = findUPar(y);

        if(nx==ny) return;
        if(rank[nx] < rank[ny]){
            parent[nx]  = ny;
            rank[ny] = nx;
        }
        else{
            parent[ny] = nx;
            rank[nx] = ny;
        }
    }

}
public class MinimumSpanningTreeKruskals {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        List<Edge> edgLst = new ArrayList<>();
        for(int i = 0; i < V;i++){
            for(int j =0; j < adj.get(i).size();j++){
                int[] curr = adj.get(i).get(j);
                int adjNode = curr[0];
                int wt = curr[1];
                edgLst.add(new Edge(i, adjNode, wt));
            }
        }
        Collections.sort(edgLst);
        int min = 0;
        DisjointSet ds = new DisjointSet(V);
        for(Edge edg1 : edgLst){
            // String c = edg1.v+","+edg1.e;
            if(ds.findUPar(edg1.e) != ds.findUPar(edg1.v)){
                min += edg1.w;
                ds.unionBySize(edg1.v,edg1.e);
            }
        }

        return min;
    }

}
