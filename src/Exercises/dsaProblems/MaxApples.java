package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxApples {
    static int memo[][][];

    public static void main(String[] args) {
        // Create the sample 4x4 grid
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, -1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(0, -1, -1, 1)));

        System.out.println("Maximum apples collected: " + collectApples(matrix));
    }

    // Check whether coordinates are valid or not.
    public static Boolean valid(ArrayList<ArrayList<Integer>> matrix, int r1, int c1, int r2, int c2) {
        int n = matrix.size();
        if (r1 >= 0 && c1 >= 0 && r1 < n && c1 < n && matrix.get(r1).get(c1) != -1 && r2 >= 0 && c2 >= 0 && r2 < n && c2 < n && matrix.get(r2).get(c2) != -1) {
            return true;
        }

        return false;
    }

    public static int solve(ArrayList<ArrayList<Integer>> matrix, int r1, int c1, int c2) {
        int n = matrix.size();

        // As r1+c1 == r2+c2 so, r2 = r1+c1-c2.
        int r2 = r1 + c1 - c2;

        // Base Case.
        if (r1 == n - 1 && c1 == n - 1) {
            return matrix.get(r1).get(c1);
        }
        if (r2 == n - 1 && c2 == n - 1) {
            return matrix.get(r2).get(c2);
        }

        // If state is already explored.
        if (memo[r1][c1][c2] != -1) {
            return memo[r1][c1][c2];
        }

        // Recursive Calls.
        int ans;
        if (r1 == r2 && c1 == c2) {
            ans = matrix.get(r1).get(c1);
        } else {
            ans = matrix.get(r1).get(c1) + matrix.get(r2).get(c2);
        }

        // Both down.
        int downDown = Integer.MIN_VALUE;
        if (valid(matrix, r1 + 1, c1, r2 + 1, c2)) {
            downDown = solve(matrix, r1 + 1, c1, c2);
        }

        // First down and second right.
        int downRight = Integer.MIN_VALUE;
        if (valid(matrix, r1 + 1, c1, r2, c2 + 1)) {
            downRight = solve(matrix, r1 + 1, c1, c2 + 1);
        }

        // First right and second down.
        int rightDown = Integer.MIN_VALUE;
        if (valid(matrix, r1, c1 + 1, r2 + 1, c2)) {
            rightDown = solve(matrix, r1, c1 + 1, c2);
        }

        // Both right.
        int rightRight = Integer.MIN_VALUE;
        if (valid(matrix, r1, c1 + 1, r2, c2 + 1)) {
            rightRight = solve(matrix, r1, c1 + 1, c2 + 1);
        }

        ans = ans + Math.max(downDown, Math.max(downRight, Math.max(rightDown, rightRight)));
        return memo[r1][c1][c2] = ans;
    }

    public static int collectApples(ArrayList<ArrayList<Integer>> matrix) {
        int n = matrix.size();

        // Handling corner cases.
        if (matrix.get(0).get(0) == -1 || matrix.get(n-1).get(n-1) == -1) {
            return 0;
        }

        // Initializing memo table.
        memo = new int[n][n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(memo[i][j],-1);
            }
        }

        return Math.max(0, solve(matrix, 0, 0, 0));
    }
}
