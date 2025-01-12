package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjacentIncreasingSubarraysDetectionI {
    public static void main(String[] args) {
        List<Integer> l = new ArrayList<>(Arrays.asList(2,5,7,8,9,2,3,4,3,1));
        System.out.println(hasIncreasingSubarrays(l,1));
    }
    public static boolean isStrictlyIncreasing(List<Integer> nums, int start, int k) {
        for (int i = start; i < start + k - 1; i++) {
            if (nums.get(i) >= nums.get(i + 1)) return false;
        }
        return true;
    }

    public static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        if (n < 2 * k) return false;

        for (int i = 0; i <= n - 2 * k; i++) {
            if (isStrictlyIncreasing(nums, i, k) && isStrictlyIncreasing(nums, i + k, k)) {
                return true;
            }
        }

        return false;
    }
}
