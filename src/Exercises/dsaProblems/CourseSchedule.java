package Exercises.dsaProblems;

import java.util.*;



public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println(canFinish(5,new int[][]{{1,4},{2,4},{3,1},{3,2}}));
    }

    public static boolean canFinish(int n, int[][] p) {
//        List<Integer>[] adj = new List[n];
//        int[] indegree = new int[n];
//        List<Integer> ans = new ArrayList<>();
//
//        for (int[] pair : p) {
//            int course = pair[0];
//            int prerequisite = pair[1];
//            if (adj[prerequisite] == null) {
//                adj[prerequisite] = new ArrayList<>();
//            }
//            adj[prerequisite].add(course);
//            indegree[course]++;
//        }
//
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < n; i++) {
//            if (indegree[i] == 0) {
//                queue.offer(i);
//            }
//        }
//
//        while (!queue.isEmpty()) {
//            int current = queue.poll();
//            ans.add(current);
//
//            if (adj[current] != null) {
//                for (int next : adj[current]) {
//                    indegree[next]--;
//                    if (indegree[next] == 0) {
//                        queue.offer(next);
//                    }
//                }
//            }
//        }
//
//        return ans.size() == n;



























        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        Map<Integer,List<Integer>> hm = new HashMap<>();
        int[] indegree = new int[n];
        for(int i = 0;i<p.length;i++){
            if (hm.get(p[i][1])==null){
                List<Integer> temp = new ArrayList<>();
                hm.put(p[i][1],temp);
            }
            hm.get(p[i][1]).add(p[i][0]);
            indegree[p[i][0]]++;
        }

        for(int i = 0;i <n;i++){
            if(indegree[i] == 0)
                q.offer(i);
        }

        while(!q.isEmpty()){
            int curr = q.poll();
            ans.add(curr);
            if(hm.get(curr) != null){
                List<Integer> temp = hm.get(curr);
                for(int i = 0; i<temp.size();i++ ){
                    indegree[temp.get(i)]--;
                    if(indegree[temp.get(i)] == 0){
                        q.offer(temp.get(i));
                    }
                }
            }
        }
        return ans.size() == n;
    }
}
