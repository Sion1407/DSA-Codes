package Exercises.dsaProblems.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MaxApplesEaten {
    public static void main(String[] args) {
//        System.out.println(eatenApples(new int[]{3,1,1,0,0,2},new int[]{3,1,1,0,0,2}));
        System.out.println(Arrays.toString(topKFrequent(new int[]{1,2},2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[1] - a[1]);
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i = 0;i<nums.length; i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> e: hm.entrySet()){
            pq.offer(new int[]{e.getKey(),e.getValue()});
        }
        int[] res = new int[k];
        int i = 0;
        while(i<k){
            System.out.println(Arrays.toString(pq.peek()));
            int[] temp = pq.poll();
            res[i] = temp[0];
            i++;
        }
        return res;
    }
    public static int eatenApples(int[] apples, int[] days) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); // [expiry, count]
        int day = 0, res = 0;
        while (day < apples.length || !pq.isEmpty()) {
            // If apples grow today, add them to the heap
            if (day < apples.length && apples[day] > 0) {
                pq.offer(new int[]{day + days[day], apples[day]});
            }

            //  Remove all expired apples
            while (!pq.isEmpty() && pq.peek()[0] <= day) {
                pq.poll();
            }

            //  Eat one apple if available
            if (!pq.isEmpty()) {
                int[] top = pq.poll();
                top[1]--;
                res++;
                if (top[1] > 0) {
                    pq.offer(top);
                }
            }
            

            day++;
        }

        return res;
    }

}
