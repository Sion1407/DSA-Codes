package Exercises.dsaProblems;

//3239
public class MinNoOfFlipsToMakeBinGridPali {
    public static void main(String[] args) {
        System.out.println(minFlips(new int[][]{{0,1},{0,1},{0,0}}));
    }
    public static int minFlips(int[][] grid) {
        return Math.min(row(grid),column(grid));
    }

    private static int row(int[][] a){
        int c = 0;
        for (int i = 0; i < a.length; i++) {
            int j = 0, k = a[0].length-1;
            while (j<=k){
                if (a[i][j]!=a[i][k]){
                    c++;
                }
                j++;k--;
            }
        }
        return c;
    }
    private static int column(int[][] a){
        int c = 0;
        for (int i = 0; i < a[0].length; i++) {
            int j = 0, k = a.length-1;
            while (j<=k){
                if (a[j][i]!=a[k][i]){
                    c++;
                }
                j++;k--;
            }
        }
        return c;
    }
}
