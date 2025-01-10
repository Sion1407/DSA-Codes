package Exercises.dsaProblems;

//1004
public class MaxConsecutiveOne3 {
    public static void main(String[] args) {
        System.out.println(longestOnes(new int[]{1,1,1,0,0,0,1,1,1,1,0},2));
    }
    public static int longestOnes(int[] nums, int k) {
        int result = 0;
        int left = 0;
        int zeroes = 0;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) {
                zeroes++;
                while(zeroes > k) {
                    int val = nums[left++];
                    if(val == 0) zeroes--;
                }
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
