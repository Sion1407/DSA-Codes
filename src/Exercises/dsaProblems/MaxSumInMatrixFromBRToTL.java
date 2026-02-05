package Exercises.dsaProblems;

public class MaxSumInMatrixFromBRToTL {
    public static void main(String[] args) {
        int[][] mat = new int[][]{{1, 2, 3},{4,5,6},{7,8,9}};
//        from bottom right to top left find max sum
//        u can go up and right
//        int[][] dir = new int[][]{{-1,0},{0,-1}};
//        int i = mat.length-1, j = mat[0].length-1;
//
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> b[2]- a[2]);
//        pq.offer(new int[]{i,j,mat[i][j]});
//        boolean vis[][] = new boolean[mat.length][mat[0].length];
//        int maxSum = Integer.MIN_VALUE;
//        while (!pq.isEmpty()){
//            int[] curr = pq.poll();
//            int currI = curr[0], currJ = curr[1], currSum = curr[2];
//            if (currI==0 && currJ == 0)
//                break;
//            if (vis[currI][currJ]) continue;
//            vis[currI][currJ] = true;
//            for(int[] d : dir){
//                int nI = currI+d[0];
//                int nJ = currJ + d[1];
//                if (nI>0 && nI < mat.length && nJ>0 && nJ < mat[0].length ){
//                    if (mat[nI][nJ]+currSum > maxSum) {
//                        maxSum = mat[nI][nJ]+currSum;
//                        pq.add(new int[]{nI, nJ, maxSum});
//                    }
//                }
//            }
//
//        }
//        System.out.println(maxSum);
        System.out.println(helper(mat, mat.length-1,mat[0].length-1,new int[mat.length][mat[0].length]));
    }

    private static int helper(int[][] grid, int i, int j,int[][] dp){
        if (i<0 || j < 0)
            return Integer.MIN_VALUE;
        if (i==0 && j==0){
            return grid[i][j];
        }
        if (dp[i][j]!=0) return dp[i][j];
        return dp[i][j]  = grid[i][j] + Math.max(helper(grid,i-1,j,dp),helper(grid,i,j-1,dp));

    }

}
//select max(salary) from employees where salary < (select Max(salary) from employees);