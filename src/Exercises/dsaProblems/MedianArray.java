package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MedianArray {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2}));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        double res = 0;
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for(int i =0;i<nums1.length;i++){
//            pq.offer(nums1[i]);
//        }
//        for(int i =0;i<nums2.length;i++){
//            pq.offer(nums2[i]);
//        }
//        int n = pq.size();
//        if(n%2==0){
//            while(pq.size()>(n/2) + 1){
//                pq.poll();
//            }
//            int t1 = 0, t2 = 0;
//            if (!pq.isEmpty())
//                t1 = pq.poll();
//            if (!pq.isEmpty())
//                t2 = pq.poll();
//
//            res = (double) (t1 + t2) /2;
//        }
//        else{
//            while(pq.size()>n/2+1){
//                pq.poll();
//            }
//            res = pq.poll();
//        }
//        return res;

        int m = nums1.length, n = nums2.length;
        int[] arr = new int[m + n];
        int m1 = 0, n1 = 0, i = 0;
        double median;

        // Merge nums1 and nums2 into arr[]
        while (m1 < m && n1 < n) {
            if (nums1[m1] <= nums2[n1]) {
                arr[i++] = nums1[m1++];
            } else {
                arr[i++] = nums2[n1++];
            }
        }

        // Copy remaining elements from nums1
        while (m1 < m) {
            arr[i++] = nums1[m1++];
        }

        // Copy remaining elements from nums2
        while (n1 < n) {
            arr[i++] = nums2[n1++];
        }

        // Find the median
        int len = m + n;
        if (len % 2 == 0) {
            median = (arr[len / 2 - 1] + arr[len / 2]) / 2.0;
        } else {
            median = arr[len / 2];
        }

        return median;

    }
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
//        int [] merged = new int[nums1.length + nums2.length];
////        List<Integer> merged = new ArrayList<>();
//        mergeArrays(nums1,nums2,nums1.length,nums2.length,merged);
//        int min = 0;
//        int i =0;
//        if (merged.length%2!=0){
//            return merged[merged.length/2];
//        }
//        else {
//            return (double) (merged[merged.length/2]+merged[(merged.length/2)-1])/2;
//        }
//    }
//    public static void mergeArrays(int[] arr1, int[] arr2, int n1, int n2, int[] arr3){
//        int i = 0;
//        int j = 0;
//        int k = 0;
//
//        // traverse the arr1 and insert its element in arr3
//        while(i < n1){
//            arr3[k++] = arr1[i++];
//        }
//
//        // now traverse arr2 and insert in arr3
//        while(j < n2){
//            arr3[k++] = arr2[j++];
//        }
//
//        // sort the whole array arr3
//        Arrays.sort(arr3);
//    }
}
