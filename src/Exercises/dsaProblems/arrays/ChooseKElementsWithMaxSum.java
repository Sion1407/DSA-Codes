package Exercises.dsaProblems.arrays;

import java.util.*;

public class ChooseKElementsWithMaxSum {
    public static void main(String[] args) {
        long[] res = findMaxSum(new int[]{2,2,2,2}, new int[]{3,1,2,3},1);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        long[] res = new long[nums1.length];
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        Integer[] indices = new Integer[nums1.length];
        for (int i = 0; i < nums1.length; i++) indices[i] = i;
        Arrays.sort(indices, Comparator.comparingInt(i -> nums1[i]));
//        for (int i = 0; i < nums1.length; i++) {
//            List<Integer> t = new ArrayList<>();
//            for (int j = 0; j < nums1.length; j++) {
//                if (i==j) continue;
//                if (nums1[i]> nums1[j]){
//                    t.add(j);
//                }
//            }
//            for (int j : t) {
//                pq.offer(nums2[j]);
//                if (pq.size()>k){
//                    pq.poll();
//                }
//            }
//            int sum = 0;
//            while (!pq.isEmpty()){
//                sum+=pq.poll();
//            }
//            res[i] = sum;
//        }

        for (int i = 0; i < nums1.length; i++) indices[i] = i;
        Arrays.sort(indices, Comparator.comparingInt(i -> nums1[i]));

        for (int i : indices) {
            PriorityQueue<Integer> tempPQ = new PriorityQueue<>();
            for (int j = 0; j < nums1.length; j++) {
                if (i != j && nums1[i] > nums1[j]) {
                    tempPQ.offer(nums2[j]);
                    if (tempPQ.size() > k) {
                        tempPQ.poll();
                    }
                }
            }


            long sum = 0;
            while (!tempPQ.isEmpty()) {
                sum += tempPQ.poll();
            }
            res[i] = sum;
        }
        return res;
    }
}













