package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int l = 0, r = l+1 , sum = 0;
        List<List<Integer>> res = new ArrayList<>();
        combSum(target, res, 0, new ArrayList<>(), candidates);
        return res;

    }
    private static void combSum(int target, List<List<Integer>> res,int start, List<Integer> temp , int [] nums){
        if (target<0){
            return;
        }
        if (start == nums.length){
            if (target==0){
                res.add(new ArrayList<>(temp));
            }
            return;
        }
        if (nums[start] <= target){
            temp.add(nums[start]);
            combSum(target - nums[start], res, start, temp, nums);
            temp.remove(temp.size()-1);
        }
        combSum(target,res,start+1,temp,nums);
    }

}
