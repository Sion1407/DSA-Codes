package Exercises.dsaProblems;

import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        int [][] res= merge(new int[][]{{1,4},{2,3}});
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[i].length; j++) {
                System.out.print(res[i][j]);
            }
            System.out.println();
        }
    }

    public static int[][] merge(int[][] intervals) {
        int[][] merged = new int[intervals.length][2];
        Arrays.sort(intervals, (a,b)-> Integer.compare(a[0],b[0]));
        int m = 0;
        merged[m][0] = intervals[0][0];
        merged[m][1] = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
//            if the last index of the interval is greater than the first index of the array then it is overlapping
            if (merged[m][1] >= intervals[i][0]){
                if (merged[m][1] < intervals[i][1])
                    merged[m][1] = intervals[i][1];
            }
            else{
                m++;
                merged[m][0] = intervals[i][0];
                merged[m][1] = intervals[i][1];
            }
        }

        int[][] result = new int[m + 1][2];
        for (int i = 0; i <= m; i++) {
            result[i][0] = merged[i][0];
            result[i][1] = merged[i][1];
        }

        return result;
    }
}
