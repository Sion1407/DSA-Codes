package Exercises.dsaProblems;
//59

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix2 {
    enum Directions{
        RIGHT,UP,DOWN,LEFT
    }
    public static void main(String[] args) {
        int [][] res = generateMatrix(3);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.println(res[i][j]);
            }
        }
    }

    public static int[][] generateMatrix(int n) {
        int [][] ans = new int[n][n];
        int [][] matrix = new int[n][n];
        boolean[][] check = new boolean[n][n];
        int k = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = k;
                k++;
            }
        }
        int i=0,j=0;
        k = 1;
        List<Integer> ans1 = new ArrayList<>();
        SpiralMatrix.Directions directions = SpiralMatrix.Directions.RIGHT;
        while (ans1.size() < (n*n)){
            ans1.add(matrix[i][j]);
            ans[i][j] = k;
            check[i][j] = true;
            switch (directions){
                case RIGHT:
                    if (j+1<n && !check[i][j+1]){
                        j++;
                    }
                    else{
                        directions = SpiralMatrix.Directions.DOWN;
//                        to go down
                        i++;
                    }
                    break;
                case DOWN:
                    if (i+1 < n && !check[i+1][j]){
                        i++;
                    }
                    else{
                        directions = SpiralMatrix.Directions.LEFT;
//                        to go left
                        j--;
                    }
                    break;
                case LEFT:
                    if (j-1>=0 && !check[i][j-1]){
                        j--;
                    }
                    else{
                        directions = SpiralMatrix.Directions.UP;
                        i--;
                    }
                    break;
                case UP:
                    if (i-1 >=0 && !check[i-1][j]){
                        i--;
                    }
                    else{
                        directions = SpiralMatrix.Directions.RIGHT;
                        j++;
                    }
                    break;
            }
            k++;
        }
        return ans;
    }
}
