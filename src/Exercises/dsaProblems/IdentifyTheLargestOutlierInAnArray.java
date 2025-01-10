package Exercises.dsaProblems;

import java.util.HashMap;
import java.util.Map;

public class IdentifyTheLargestOutlierInAnArray {
    public static void main(String[] args) {
        System.out.println(getLargestOutlier(new int[]{1,1,1,1,1,5,5}));
    }
    public static int getLargestOutlier(int[] nums) {
        Map<Integer,Integer> hm = new HashMap<>();
        int sum = 0,n = nums.length,res=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
            sum+=nums[i];
        }

        for (int a : nums) {
            int outlier = sum - a - a;
            if (hm.getOrDefault(outlier, 0) > (outlier == a ? 1 : 0)) {
                res = Math.max(res, outlier);
            }
        }
        return res;
    }
}
