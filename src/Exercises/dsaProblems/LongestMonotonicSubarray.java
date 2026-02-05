package Exercises.dsaProblems;

public class LongestMonotonicSubarray {
    public static void main(String[] args) {
        System.out.println(longestMonotonicSubarray(new int[]{1}));
    }
    public static int longestMonotonicSubarray(int[] nums) {
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            int t = 1, j = i;
            while (j < nums.length && nums[j-1] - nums[j] > 0 ){
                t++;
                j++;
            }
            max = Math.max(max,t);
            t = 1; j = i;
            while (j < nums.length && nums[j-1] - nums[j] < 0 ){
                t++;
                j++;
            }
            max = Math.max(max,t);
        }
        return max;

    }
}
