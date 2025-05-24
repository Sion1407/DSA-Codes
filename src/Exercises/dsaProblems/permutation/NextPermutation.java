package Exercises.dsaProblems.permutation;

import java.util.Arrays;
import java.util.PriorityQueue;

public class NextPermutation {
    public static void main(String[] args) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> a[0]-b[0]);
        pq.add(new int[]{0,0,0});
        int[] t = pq.poll();


        int[] res = new int[]{1, 3, 2};
        nextPermutation(res);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }

    //    find first decreasing ele from right
//    then find largest element from decreasing ele from right
//    swap and sort the subarray
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 1;
        while (i > 0 && nums[i - 1] >= nums[i]) {
            i--;
        }
        if (i == 0) {
            reverse(nums, 0, nums.length - 1);
            return;
        }
        int j = nums.length - 1;
        while (j >= i && nums[j] <= nums[i - 1]) {
            j--;
        }
        swap(nums, i - 1, j);
        reverse(nums, i, nums.length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
