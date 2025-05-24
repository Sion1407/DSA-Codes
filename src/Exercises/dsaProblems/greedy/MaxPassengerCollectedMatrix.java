package Exercises.dsaProblems.greedy;

public class MaxPassengerCollectedMatrix {
    public static void main(String[] args) {
        System.out.println(maxPass(new int[][]{{0,0,0,1},{1,0,0,0},{0,0,0,0},{0,0,0,0}}));
    }
    public static int maxPass(int[][] mat){

        int pass = reachLast(mat.length,mat[0].length,mat,0,0,0);
        int returnpass = reachBack(mat,mat.length-1,mat[0].length-1,0);
        return pass + returnpass;
    }

    private static int reachLast(int r, int c, int[][] mat,int currR,int currC,int p){
        if (currR>=r || currC >= c){
            return 0;
        }
        if (currR==r-1 && currC==c-1)
            return p ;
        int passengers = 0;
        if (mat[currR][currC] == 1) {
            passengers = 1;
            mat[currR][currC] = 0;
        }
        if (mat[currR][currC]==-1)
            return 0;
        int right = reachLast(r,c,mat,currR,currC+1,p+passengers);
        int down = reachLast(r,c,mat,currR+1,currC,p+passengers);

        if (passengers == 1) {
            mat[currR][currC] = 1;
        }
        return Math.max(right,down);
    }

    private static int reachBack(int[][] mat, int currR, int currC, int p) {
        // Check if current cell is out of bounds or is an obstruction
        if (currR < 0 || currC < 0 || mat[currR][currC] == -1) {
            return 0;
        }

        // Check if reached the starting point
        if (currR == 0 && currC == 0) {
            return p;
        }

        // Pick up passenger if present
        int passengers = 0;
        if (mat[currR][currC] == 1) {
            passengers = 1;
            mat[currR][currC] = 0; // Mark the cell as empty after picking up the passenger
        }

        // Move left and up
        int left = reachBack(mat, currR, currC - 1, p + passengers);
        int up = reachBack(mat, currR - 1, currC, p + passengers);

        // Restore the cell value if a passenger was picked up
        if (passengers == 1) {
            mat[currR][currC] = 1;
        }

        return Math.max(left, up);
    }


}
