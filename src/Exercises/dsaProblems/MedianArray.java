package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MedianArray {
    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,3},new int[]{2,4}));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){
        int [] merged = new int[nums1.length + nums2.length];
//        List<Integer> merged = new ArrayList<>();
        mergeArrays(nums1,nums2,nums1.length,nums2.length,merged);
        int min = 0;
        int i =0;
        if (merged.length%2!=0){
            return merged[merged.length/2];
        }
        else {
            return (double) (merged[merged.length/2]+merged[(merged.length/2)-1])/2;
        }
    }
    public static void mergeArrays(int[] arr1, int[] arr2, int n1, int n2, int[] arr3){
        int i = 0;
        int j = 0;
        int k = 0;

        // traverse the arr1 and insert its element in arr3
        while(i < n1){
            arr3[k++] = arr1[i++];
        }

        // now traverse arr2 and insert in arr3
        while(j < n2){
            arr3[k++] = arr2[j++];
        }

        // sort the whole array arr3
        Arrays.sort(arr3);
    }
}
