package Exercises.dsaProblems;

import java.util.*;

public class KthNearestObstacle {
    public static void main(String[] args) {
        int [] res = resultsArray(new int[][]{{5,5},{4,4},{3,3}},1);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static int[] resultsArray(int[][] queries, int k) {
//        (a,b) -> b-a is a comparator and makes insertion in descending order, by def is ascending
        PriorityQueue<Integer> q = new PriorityQueue<>((a,b) -> b-a);
        int[] res = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            q.offer(Math.abs(queries[i][0]) + Math.abs(queries[i][1]));
            if (q.size() > k){
                q.poll();
            }
            if(q.size() == k) {
                res[i] = q.peek();
            }
            else{
                res[i] = -1;
            }
        }
        return res;
    }
}
