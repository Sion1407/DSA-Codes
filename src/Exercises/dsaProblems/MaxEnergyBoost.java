package Exercises.dsaProblems;

public class MaxEnergyBoost {
    public static void main(String[] args) {
        System.out.println(maxEnergyBoost(new int[]{1,3,1},new int[]{3,1,1}));
    }

    static long[][] memo;
    public static long maxEnergyBoost(int[] a, int[] b) {
        memo = new long[100001][2];
        long aMax = helper(0,a,b,0);
        long bMax = helper(0,a,b,1);
        return Math.max(aMax,bMax);
    }
    static long helper(int i, int[] a, int[] b, int f){
        if(i>=a.length) return 0;
        if(memo[i][f]!=0) return memo[i][f];
        if(f==0){
            return memo[i][f] = a[i]+Math.max(helper(i+1, a,b,0),helper(i+2,a,b,1));
        }
        return memo[i][f] = b[i]+Math.max(helper(i+2, a,b,0),helper(i+1,a,b,1));
    }
}
