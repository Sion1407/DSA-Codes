package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    enum Directions{
        RIGHT,UP,DOWN,LEFT
    }
    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
    }


    public static List<Integer> spiralOrder(int[][] matrix) {
        int r = matrix.length, c = matrix[0].length,i=0,j=0;
        boolean[][] check = new boolean[r][c];
        Directions directions = Directions.RIGHT;
        List<Integer> ans = new ArrayList<>();
        while (ans.size() < (r*c)){
            ans.add(matrix[i][j]);
            check[i][j] = true;
            switch (directions){
                case RIGHT:
                    if (j+1<c && !check[i][j+1]){
                        j++;
                    }
                    else{
                        directions = Directions.DOWN;
//                        to go down
                        i++;
                    }
                    break;
                case DOWN:
                    if (i+1 < r && !check[i+1][j]){
                        i++;
                    }
                    else{
                        directions = Directions.LEFT;
//                        to go left
                        j--;
                    }
                    break;
                case LEFT:
                    if (j-1>=0 && !check[i][j-1]){
                        j--;
                    }
                    else{
                        directions = Directions.UP;
                        i--;
                    }
                    break;
                case UP:
                    if (i-1 >=0 && !check[i-1][j]){
                        i--;
                    }
                    else{
                        directions = Directions.RIGHT;
                        j++;
                    }
                    break;
            }
        }
        return ans;

    }
}
