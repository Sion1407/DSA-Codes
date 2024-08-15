package Exercises.dsaProblems;
//64
public class MinimumPathSum {
    public static void main(String[] args) {
        System.out.println(minPathSum(new int[][]{{1,2,3},{4,5,6}}));
    }
    public static int minPathSum(int[][] grid) {
        int dp [][] = new int[grid.length][grid[0].length];
        return helper(grid,0,0,dp);

    }
    private static int helper(int[][] grid, int i, int j,int[][] dp){
        if (i>=(grid.length) || j>=(grid[0].length))
            return Integer.MAX_VALUE;
        if (i==(grid.length-1) && j==(grid[0].length-1)){
            return grid[i][j];
        }
        if (dp[i][j]!=0) return dp[i][j];
        return dp[i][j]  = grid[i][j] + Math.min(helper(grid,i+1,j,dp),helper(grid,i,j+1,dp));

    }
}
