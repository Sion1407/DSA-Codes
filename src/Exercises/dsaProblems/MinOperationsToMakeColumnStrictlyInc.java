package Exercises.dsaProblems;

public class MinOperationsToMakeColumnStrictlyInc {
    public static void main(String[] args) {
        System.out.println(minimumOperations(new int[][]{{3,2},{1,3},{3,4},{0,1}}));
    }
    public static int minimumOperations(int[][] grid) {
        int res = 0;
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] <= grid[i-1][j]) {
                    res += (grid[i-1][j] - grid[i][j])+1;
                    grid[i][j] = grid[i-1][j] +1;
                }
            }
        }
        return res;
    }
}
