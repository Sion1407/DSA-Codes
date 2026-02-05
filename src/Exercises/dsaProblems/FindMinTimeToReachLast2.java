package Exercises.dsaProblems;

import java.util.PriorityQueue;

public class FindMinTimeToReachLast2 {
    public static void main(String[] args) {
        System.out.println(minTimeToReach(new int[][]{{21,77},{22,11}}));
    }

    public static int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0,1});
        int dir [][] = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        boolean[][] vis = new boolean[n][m];
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            int currTime = curr[2];
            int stepCost = curr[3];
            if(i == n-1 && j == m-1){
                return currTime;
            }
            if(vis[i][j]) continue;
            vis[i][j] = true;
            for(int d[] : dir){
                int nI = i+d[0], nJ = j+d[1];
                if(nI >= 0 && nI < n && nJ >=0 && nJ < m){
                    int t = Math.max(currTime,moveTime[nI][nJ])+stepCost;
                    pq.add(new int[]{nI,nJ,t,3-stepCost});
                }
            }
        }
        return -1;
    }
}
