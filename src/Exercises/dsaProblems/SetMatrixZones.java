package Exercises.dsaProblems;
//73
public class SetMatrixZones {
    public static void main(String[] args) {
        int [][] res = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        setZeroes(res);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length , c= 1;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
//                marking column and row of the cell(i,j) where 0 is found
                if (matrix[i][j]==0){
                    matrix[i][0] = 0;
                    if (j!=0)
                        matrix[0][j] = 0;
                    else c = 0;
                }
            }
        }

        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                //        for making the place as 0 if the first row/column is marked as 0
                if (matrix[i][j] !=0){
                    if (matrix[i][0]==0 || matrix[0][j]==0){
                        matrix[i][j] = 0;
                    }
                }
            }
        }
        if (matrix[0][0] == 0){
            for (int i = 0; i < m; i++) {
                matrix[0][i] = 0;
            }
        }
        if (c==0){
            for (int i = 0; i < n; i++) {
                matrix[i][0] = 0;
            }
        }


    }
}
