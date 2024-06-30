package Exercises.dsaProblems;

//18. 4Sum

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    static List<List<Integer>> res = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println(fourSum(new int[]{1,0,-1,0,-2,2},0));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        int k = 4;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                int l = j+1, r = nums.length-1;
                while (l<r){
                    int sum = nums[l]+nums[r]+nums[j]+nums[i];
                    if (sum<target){
                        l++;
                    } else if (sum>target) {
                        r--;
                    }
                    else {
                        if (!res.contains(List.of(nums[i],nums[j],nums[l],nums[r])))
                            res.add(List.of(nums[i],nums[j],nums[l],nums[r]));
//                        while (l<r && nums[l]==nums[l+1])
//                            l++;
//                        while (l<r && nums[r]==nums[r-1])
//                            r--;

                        l++;r--;
                    }
                }
            }
        }
        return res;
    }
}
