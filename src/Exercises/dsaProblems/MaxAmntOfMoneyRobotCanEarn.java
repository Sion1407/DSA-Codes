package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

public class MaxAmntOfMoneyRobotCanEarn {
    public static void main(String[] args) {
        System.out.println(maximumAmount(new int[][]{{0,1,-1},{1,-2,3},{2,-3,4}}));
    }
    private static int maximumAmountRecursive(int row, int col, int neutralizers, int[][] coins){
        // out of bounds check
        if(row >= coins.length || col >= coins[0].length)
            return Integer.MIN_VALUE;

        // bottom right corner reached
        if(row == coins.length - 1 && col == coins[0].length - 1)
            return coins[row][col];

        int coinsAtCurrCell = coins[row][col];

        // option 1 : don't neutralize
        int dontNeutralize = coinsAtCurrCell +
                Math.max(
                        maximumAmountRecursive(row, col + 1, neutralizers, coins), // move right
                        maximumAmountRecursive(row + 1, col, neutralizers, coins)  // move down
                );

        // option 2 : neutralize (if possible)
        int neutralize = Integer.MIN_VALUE;
        if(coinsAtCurrCell < 0 && neutralizers > 0){
            neutralize = Math.max(
                    maximumAmountRecursive(row, col + 1, neutralizers - 1, coins), // move right
                    maximumAmountRecursive(row + 1, col, neutralizers - 1, coins)  // move down
            );
        }

        return Math.max(dontNeutralize, neutralize);
    }

    public static int maximumAmount(int[][] coins) {
        // at every point the robot has a choice to either go right or down
        // also it can neutralize atmost 2 robbers i.e. 2 neutralizations allowed
        int neutralizers = 2; // given in question

        // RECURSIVE
        return maximumAmountRecursive(0, 0, 2, coins);
    }

}
