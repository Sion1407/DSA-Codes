package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

public class ZigZagGridTraversalWithSkip {
    public static void main(String[] args) {
        System.out.println(zigzagTraversal(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }
    public static List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> res = new ArrayList<>();
        boolean f = true;
        for (int i = 0; i < grid.length; i++) {
            if (i%2 == 0) {
                for (int j = 0; j < grid[0].length; j+=1) {
                    if (f == false)
                        f = true;
                    else {
                        res.add(grid[i][j]);
                        f = false;
                    }
                }
            }
            else {
                for (int j = grid[0].length-1; j >=0 ; j-=1) {
                    if (f == false)
                        f = true;
                    else {
                        res.add(grid[i][j]);
                        f = false;
                    }
                }
            }
        }
        return res;
    }
}
