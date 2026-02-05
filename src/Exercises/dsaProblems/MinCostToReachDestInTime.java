package Exercises.dsaProblems;

import java.util.*;

public class MinCostToReachDestInTime {
    public static void main(String[] args) {
        System.out.println(minCost(30,new int[][]{{0,1,10},{1,2,10},{2,5,10},{0,3,1},{3,4,10},{4,5,15}},new int[]{5,1,2,20,20,3}));
    }

    public static int minCost(int maxTime, int[][] edges, int[] Fees) {

        int target=Fees.length-1;
        int[] visited=new int[Fees.length];
        Arrays.fill(visited,-1);
        Map<Integer,List<int[]>> map=new HashMap<>();

        for(int[] x: edges){
            int u=x[0];
            int v=x[1];
            int time=x[2];

            map.putIfAbsent(u,new ArrayList<>());
            map.putIfAbsent(v,new ArrayList<>());
            map.get(u).add(new int[]{v,time});
            map.get(v).add(new int[]{u,time});
        }

        PriorityQueue<int[]> queue=new PriorityQueue<>((a,b)->a[1]==b[1] ? a[2]-b[2] : a[1]-b[1]);
        queue.add(new int[]{0,Fees[0],0});
        visited[0]=0;
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int u=curr[0];
            int cost=curr[1];
            int time=curr[2];
            if(u==target)
                return cost;
            for(int next[] : map.get(u)){
                int v=next[0];
                if(visited[v]!=-1 && time+next[1]>=visited[v])
                    continue;
                visited[v]=time+next[1];
                if(time+next[1]<=maxTime){
                    queue.add(new int[]{v,cost+Fees[v],time+next[1]});
                }
            }
        }

        return -1;
    }
}
