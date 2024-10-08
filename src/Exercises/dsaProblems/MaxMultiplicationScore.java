package Exercises.dsaProblems;

public class MaxMultiplicationScore {
    public static void main(String[] args) {
        System.out.println(maxScore(new int[]{3,2,5,6},new int[]{2,-6,4,-5,-3,2,-7}));
    }
    static long[][] dp;
    public static long maxScore(int[] a, int[] b) {
        dp = new long[b.length][4];
        for (int i = 0; i < b.length; i++) {
            dp[i][0] = Long.MIN_VALUE;dp[i][1] = Long.MIN_VALUE;dp[i][2] = Long.MIN_VALUE;dp[i][3] = Long.MIN_VALUE;
        }
        return helper(0,0,a,b);
    }
    private static long helper(int idx,int g,int[] a,int[] b){
        if(g==4) return 0;
        if (idx==b.length) return Integer.MIN_VALUE;
        if (dp[idx][g]!=Long.MIN_VALUE) return dp[idx][g];
        long dontTake = helper(idx+1,g,a,b);
        long take = helper(idx+1,g+1,a,b) +(long) a[g]* b[idx];
        return dp[idx][g] = Math.max(dontTake,take);
    }
}
