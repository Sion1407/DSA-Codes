package Exercises.dsaProblems;

import java.util.HashMap;
import java.util.List;

public class ValidSoduku {
//            [[".",".","5",".",".",".",".",".","6"],
//            [".",".",".",".","1","4",".",".","."],
//            [".",".",".",".",".",".",".",".","."],
//            [".",".",".",".",".","9","2",".","."],
//            ["5",".",".",".",".","2",".",".","."],
//            [".",".",".",".",".",".",".","3","."],
//            [".",".",".","5","4",".",".",".","."],
//            ["3",".",".",".",".",".","4","2","."],
//            [".",".",".","2","7",".","6",".","."]]
    public static void main(String[] args) {
        System.out.println(isValidSudoku(new char[][]{
                {'.','.','5', '.','.','.', '.','.','6'},
                {'.','.','.', '.','1','4', '.','.','.'},
                {'.','.','.', '.','.','.', '.','.','.'},

                {'.','.','.', '.','.','9', '2','.','.'},
                {'5','.','.', '.','.','2', '.','.','.'},
                {'.','.','.', '.','.','.', '.','3','.'},

                {'.','.','.', '5','4','.', '.','.','.'},
                {'3','.','.', '.','.','.', '4','2','.'},
                {'.','.','.', '2','7','.', '6','.','.'}}));
    }

    public static boolean isValidSudoku(char[][] board) {
        return (checkRows(board) && checkGrid(board) && checkColoumns(board));
    }
    private static boolean checkRows(char[][] board){
        for (int i = 0; i < board.length; i++) {
            if (!isValid(board[i])){
                return false;
            }
        }
        return true;
    }
    private static boolean isValid(char[] a){
        boolean[] seen = new boolean[10];
        for (int i = 0;i< a.length;i++){
            if (a[i]!='.') {
                int num = a[i] - '0';
                if (seen[num]) {
                    return false;
                }
                seen[num] = true;
            }
        }
        return true;
    }
    private static boolean checkColoumns(char[][] board){
        for (int i = 0; i < board.length; i++) {
            char[] columns = new char[9];
            for (int j = 0; j < board[i].length; j++) {
                columns[j] = board[i][j];
            }
            if (!isValid(columns)){
                return false;
            }
        }
        return true;
    }


    private static boolean checkGrid(char[][] board) {
        HashMap<Character, List<Integer>> hm = new HashMap<>();
        for (int i = 0; i < board.length-3; i+=3){
            for (int j = 0; j < board[i].length-3; j+=3) {
                for (int k = i; k < i+3; k++) {
                    for (int l = j; l < j+3; l++) {
                        if (hm.containsKey(board[k][l])){
                            return false;
                        } else if (board[k][l]!='.') {
                            hm.put(board[k][l],List.of(k,l));
                        }
                    }
                }
                hm.clear();
            }
        }
        return true;
    }
}
