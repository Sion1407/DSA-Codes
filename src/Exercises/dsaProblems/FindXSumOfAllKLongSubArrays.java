package Exercises.dsaProblems;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FindXSumOfAllKLongSubArrays {
    public static void main(String[] args) {
        int [] res = findXSum(new int[]{1,1,2,2,3,4,2,3},6,2);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static int[] findXSum(int[] nums, int k, int x) {
        int []res = new int[nums.length-k+1];
        for (int i = 0; i < nums.length-k+1; i++) {
            res[i] = sum(nums,i,i+k-1,x);
        }
        return res;
    }
    private static int sum(int[] t, int s,int e,int x){
        Map<Integer,Integer> hm = new HashMap<>();
        int sum =0;
        for (int i = 0; i <= e; i++) {
            hm.put(t[i],hm.getOrDefault(t[i],0)+1);
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
                (a,b) -> (b.getValue()==a.getValue() ? b.getKey() - a.getValue() : b.getValue() - a.getValue())
        );
        for(Map.Entry<Integer,Integer> entry:hm.entrySet()){
            pq.add(entry);
        }
        while (x > 0 && !pq.isEmpty()){
            Map.Entry<Integer,Integer> h = pq.poll();
            sum+=h.getKey() * h.getValue();
            x--;
        }
        return sum;
    }
}
