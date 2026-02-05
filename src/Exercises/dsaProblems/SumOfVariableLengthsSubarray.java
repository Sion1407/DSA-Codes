package Exercises.dsaProblems;

public class SumOfVariableLengthsSubarray {
    public static void main(String[] args) {
        System.out.println(subarraySum(new int[]{3,1,5}));
    }
    public static int subarraySum(int[] nums) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int start = Math.max(0,i-nums[i]);
            int t = 0;
            for (int j = start; j <= i; j++) {
                t+=nums[j];
            }
            sum+=t;
        }
        return sum;
    }
}
