package Exercises.dsaProblems;

public class MinSizeSubArraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(4,new int[]{1,4,4}));
    }
    public static int minSubArrayLen(int target, int[] nums) {
        int l = 0,r= 0,res= Integer.MAX_VALUE,sum = 0;
        while(r< nums.length){
            sum += nums[r];
            while (sum >= target){
                res = Math.min(r-l+1,res);
                sum-=nums[l];
                l++;
            }
            r++;
        }
        return res;
    }
}
