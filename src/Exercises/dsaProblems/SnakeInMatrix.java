package Exercises.dsaProblems;

import java.util.List;

public class SnakeInMatrix {
    public static void main(String[] args) {
        System.out.println(finalPositionOfSnake(2,List.of("RIGHT","DOWN")));
    }
    public static int finalPositionOfSnake(int n, List<String> commands) {
        int i = 0;
        int [][] mat = new int[n][n];
        for(int j = 0;j<n;j++){
            for(int k = 0;k<n;k++){
                mat[j][k] = i;
                i++;
            }
        }
        i=0;int j = 0,itr = 0;
        while(itr<commands.size()){
            switch(commands.get(itr)){
                case "LEFT":
                    j--;
                    break;
                case "DOWN":
                    i++;
                    break;
                case "UP":
                    i--;
                    break;
                case "RIGHT":
                    j++;
                    break;
            }
            itr++;
        }
        return mat[i][j];
    }
}
