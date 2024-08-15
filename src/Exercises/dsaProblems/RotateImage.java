package Exercises.dsaProblems;

public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        rotate(matrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void rotate(int[][] matrix) {
        transposeMatrix(matrix);
        for (int i = 0; i < matrix.length; i++) {
            reverse(matrix[i]);
        }
    }

    private static void transposeMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length-1; i++) {
            for (int j = i; j < matrix.length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
    private static void reverse(int[] matrix){
        int start= 0, end = matrix.length-1;
        while (start<end){
            int temp = matrix[start];
            matrix[start] = matrix[end];
            matrix[end] = temp;
            start++;end--;
        }
    }
}
