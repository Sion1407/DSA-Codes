package Exercises.dsaProblems;

//1493
public class LongestSubarrayof1s {
    public static void main(String[] args) {
        System.out.println(longestSubarray(new int[]{1,0,0,1,0}));
    }
    public static int longestSubarray(int[] nums) {
        int zeroes = 0;
        int left = 0;
        int result = 0;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) zeroes++;

            while(zeroes == 2) {
                int val = nums[left++];
                if(val == 0) zeroes--;
            }

            result = Math.max(result, right - left);
        }
        return result;
    }
}
