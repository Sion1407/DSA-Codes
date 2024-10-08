package Exercises.dsaProblems;

import java.util.Arrays;

public class MaximiseScoreOfNumberInRanges {
    public static void main(String[] args) {
        System.out.println(maxPossibleScore(new int[]{3,0,6},2));
    }
    public static int maxPossibleScore(int[] start, int d) {
        int low = 0;
        int high = Integer.MAX_VALUE;
        int res = -1;
        Arrays.sort(start);

        while(low <= high){
            int mid = low + (high - low)/2;

            if(isValid(start, d, mid)){
                res = mid;
                low = mid + 1;
            }

            else high = mid - 1;
        }

        return res;
    }

    private static boolean isValid(int[] nums, int d, int mid){
        int n = nums.length;
        int prev = nums[0];

        for(int i=1;i<n;i++){
            if(prev + mid > nums[i] + d) return false;
            prev = Math.max(nums[i], prev + mid);
        }

        return true;
    }
}
