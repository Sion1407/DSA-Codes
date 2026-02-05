package Exercises.dsaProblems;

public class Search2DMatrix {
    public static void main(String[] args) {
        System.out.println(searchMatrix(new int[][]{{1,3,5,7},{10,11,16,20},{23,30,34,60}},3));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int l = 0, r = matrix.length-1, n = matrix[0].length;
        while(l<=r){
            int mid = (l+r)/2;
            int ml = matrix[mid][0];
            int mr = matrix[mid][n-1];

            if(target >= ml && target <= mr ){
                int i = 0;
                while(i<matrix[mid].length){
                    if(matrix[mid][i] == target) return true;
                    i++;
                }
                return false;
            }
            else if(target < ml){
                r= mid-1;
            }
            else if(target > mr){
                l = mid+1;
            }
        }
        return false;
    }
}
