package Exercises.dsaProblems;

import java.util.Arrays;

public class ThreeSumClosest {
    public static void main(String[] args) {
        System.out.println(threeSumClosest(new int[]{-1,2,1,-4},1));
    }

    public static int  threeSumClosest(int[] nums, int target) {
        int res = 0, diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        int j = 0, k = 0;
        for (int i = 0; i < nums.length-2; i++) {
            j = i+1;
            k = nums.length-1;
            while (j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if (Math.abs(target-sum)<diff){
                    res = sum;
                    diff = Math.abs(target-sum);
                }
                if (sum==target) return sum;
                else if (sum > target) {
                    k--;
                }
                else j++;
            }


        }

        return res;
    }
}
