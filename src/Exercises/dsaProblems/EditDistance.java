package Exercises.dsaProblems;

public class EditDistance {
    public static void main(String[] args) {
        System.out.println(minDistance("horse","ros"));
    }

    public static int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()+1][word2.length()+1];
        for (int i = 0; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= word2.length(); i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                if(word1.charAt(i)==word2.charAt(j)){
                    dp[i+1][j+1] = dp[i][j];
                }
                else{
//                    dp[i][j+1] - insert (as we insert char in word1 before i and then we need to move j for
//                    comparing other char)
//                    dp[i+1][j] - delete (as we delete from word1 then we need to move our i to next char)
//                    dp[i+1][j+1] - replace(we move both i and j as word1 and word2 char will be equal)
                    int temp = Math.min(dp[i+1][j],dp[i][j]);
                    dp[i+1][j+1] = Math.min(temp,dp[i][j+1]);
                    dp[i+1][j+1]++;
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}
