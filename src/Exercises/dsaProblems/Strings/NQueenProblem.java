package Exercises.dsaProblems.Strings;

import java.util.ArrayList;
import java.util.List;

public class NQueenProblem {
    public static void main(String[] args) {
        System.out.println(solveNQueens(4));
    }
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char [][] board = new char[n][n];
        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                board[i][j] = '.';
            }
        }
        findAllFit(board,res,0);
        return res;
    }

    static void findAllFit(char[][] b, List<List<String>> res, int row){
        if(row==b.length){
            res.add(construct(b));
            return;
        }

        for(int col = 0; col< b[0].length;col++){
            if(valid(row,col,b)){
                b[row][col] = 'Q';
                findAllFit(b,res,row+1);
                b[row][col] = '.';
            }
        }
    }

    static boolean valid(int r, int c, char[][] b){
        // checking for if q is present in row
        for(int i = 0;i<b.length;i++){
            if(b[i][c] == 'Q')
                return false;
        }

        // for left diag /
        int maxLeft = Math.min(r,c);
        for(int i = 0 ;i <= maxLeft; i++){
            if(b[r-i][c-i]=='Q')
                return false;
        }

        // for right diag \
        int maxRight = Math.min(r, b.length - 1 - c);

        for(int i =0;i <= maxRight ; i++){
            if(b[r-i][c+i] == 'Q')
                return false;
        }

        return true;

    }

    static List<String> construct(char[][] b){
        List<String> r = new ArrayList<>();
        for(int i = 0;i< b.length;i++){
            String s = new String(b[i]);
            r.add(s);
        }
        return r;
    }
}
