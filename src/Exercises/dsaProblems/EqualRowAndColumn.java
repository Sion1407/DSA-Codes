package Exercises.dsaProblems;

import java.util.HashMap;

//2352
public class EqualRowAndColumn {
    public static void main(String[] args) {
        System.out.println(equalPairs(new int[][]{{11,1},{1,11}}));
    }

    public static int equalPairs(int[][] grid) {
        HashMap<String,Integer> hm = new HashMap<>();
        int res = 0;
        for(int i =0;i<grid.length;i++){
            String row = "";
            for(int j = 0;j< grid[i].length;j++){
                row+=String.valueOf(grid[i][j]);
            }
            hm.put(row,hm.getOrDefault(row,0)+1);
        }
        System.out.println(hm);
        for(int i =0;i<grid.length;i++){
            String col = "";
            for (int j = 0; j < grid[i].length; j++) {
                col+=String.valueOf(grid[j][i]);
            }
            if (hm.containsKey(col))
                res+=hm.get(col);
        }
        return res;
    }
}
