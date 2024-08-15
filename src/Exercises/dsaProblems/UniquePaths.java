package Exercises.dsaProblems;

public class UniquePaths {
    static int [][] memo;
    public static void main(String[] args) {
        System.out.println(uniquePaths(3,7));
    }

    public static int uniquePaths(int m, int n) {
        memo = new int[m][n];
        return helper(0,0);
    }
    public static int helper(int m,int n){
        if (m>=memo.length || n >= memo[0].length){
            return 0;
        }
        if (m == memo.length-1 && n == memo[0].length-1){
            return 1;
        }

        if (memo[m][n]>0) return memo[m][n];
        return memo[m][n] = helper(m,n+1) + helper(m+1,n);

    }
}
