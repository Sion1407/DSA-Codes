package Exercises.DSU;

public class DetectCycleIn2DGrid {
    public static void main(String[] args) {
        System.out.println(containsCycle(new char[][]{{'a','b','b'},{'b','z','b'},{'b','b','a'}}));
    }
    static class DSU{
        int [] rank;
        int[] parent;
        DSU(int s){
            parent = new int[s + 1];
            rank = new int[s + 1];

            for (int i = 1; i < s+1; i++) {
                parent[i] = i;
                rank[i] = i;
            }
        }
        public int find(int idx){
            if (parent[idx] != idx){
                parent[idx] = find(parent[idx]);
            }
            return parent[idx];
        }
        public boolean union(int c, int n){
            int rootU = find(c);
            int rootV = find(n);

            if (rootU == rootV)
                return true;
            else if (rank[rootU] >rank[rootV]) {
                parent[rootV] = rootU;
            } else if (rank[rootV]>rank[rootU]) {
                parent[rootU] = rootV;
            }
            else {
                parent[rootV] = rootU; // it doesnt matter as both are equal
                rank[rootU]++;
            }
            return false;
        }
    }
    public static boolean containsCycle(char[][] grid) {
        int [][]dir = new int[][]{{0,1},{1,0}};
        DSU dsu = new DSU(grid.length * grid[0].length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int currIdx = i*grid[0].length+j;

                for (int[] d: dir) {
                    int ni = i+d[0],nj = j+d[1];
                    if (ni>=0 && ni < grid.length && nj>=0 && nj< grid[0].length && grid[i][j]==grid[ni][nj]){
                        int neighborIdx = ni * grid[0].length + nj;
                        if (dsu.union(currIdx,neighborIdx)){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
