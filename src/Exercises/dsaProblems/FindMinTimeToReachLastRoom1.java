package Exercises.dsaProblems;

import java.util.PriorityQueue;

public class FindMinTimeToReachLastRoom1 {
    public static void main(String[] args) {
        System.out.println(minTimeToReach(new int[][]{{0,4},{4,4}}));
    }

//    public static int minTimeToReach(int[][] mt) {
//        int n = mt.length, m = mt[0].length;
//        int [][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
//        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
//        boolean[][] vis = new boolean[n][m];
//        pq.offer(new int[]{0,0,0});
//        while (!pq.isEmpty()){
//            int[] curr = pq.poll();
//            int i = curr[0];
//            int j = curr[1];
//            int time = curr[2];
//
//            if (i==n-1 && j==m-1){
//                return time;
//            }
//
//            if (vis[i][j])
//                continue;
//            vis[i][j] = true;
//            for (int[] d:dir) {
//                int newI = i + d[0];
//                int newJ = j+d[1];
//                if (newI>=0 && newI<n && newJ>=0 && newJ<m && !vis[newI][newJ]){
//                    int nextTime = Math.max(time+1,mt[newI][newJ]);
//                    pq.offer(new int[]{newI,newJ,nextTime});
//                }
//            }
//        }
//        return -1;
//    }

    public static int minTimeToReach(int[][] mt) {
        int n = mt.length, m = mt[0].length;
        int[][] dir = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        boolean[][] vis = new boolean[n][m];

        // Start from the top-left corner (0, 0) at time 0
        pq.offer(new int[]{0, 0, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0];
            int j = curr[1];
            int time = curr[2];

            // Check if we reached the bottom-right corner
            if (i == n - 1 && j == m - 1) {
                return time;
            }

            // Skip if already visited
            if (vis[i][j]) continue;
            vis[i][j] = true;

            // Explore all directions
            for (int[] d : dir) {
                int newI = i + d[0];
                int newJ = j + d[1];

                // Check bounds and if the cell is not visited
                if (newI >= 0 && newI < n && newJ >= 0 && newJ < m && !vis[newI][newJ]) {
                    // Calculate the next time considering the move and waiting
                    int nextTime = 1+ Math.max(time, mt[newI][newJ]);
                    pq.offer(new int[]{newI, newJ, nextTime});
                }
            }
        }

        return -1; // If no path exists (shouldn't occur with valid input)
    }

}
