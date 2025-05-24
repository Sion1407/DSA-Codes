package Exercises.dsaProblems;

import java.util.*;

//3446
public class SortMatrixDiagonally {
    public static void main(String[] args) {
        int[][] ressortMatrix = sortMatrix(new int[][]{{1,7,3},{9,8,2},{4,5,6}});
        for (int i = 0; i <ressortMatrix.length ; i++) {
            for (int j = 0; j < ressortMatrix[i].length; j++) {
                System.out.print(ressortMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static int[][] sortMatrix(int[][] grid) {
        Map<Integer, List<Integer>> hm = new HashMap<>();

        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int k = i-j;
                hm.putIfAbsent(k,new ArrayList<>());
                hm.get(k).add(grid[i][j]);
            }
        }
        for (Map.Entry<Integer,List<Integer>> e : hm.entrySet()){
            List<Integer> t = e.getValue();
            if (e.getKey() < 0){
                Collections.sort(e.getValue());
            }
            else
                e.getValue().sort(Comparator.reverseOrder());
        }

        for (int i = 0; i <grid.length ; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int k = i-j;
                grid[i][j] = hm.get(k).remove(0);
            }
        }
        return grid;
    }
}
