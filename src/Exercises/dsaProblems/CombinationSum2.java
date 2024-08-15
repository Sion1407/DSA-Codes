package Exercises.dsaProblems;

import java.util.*;

//40
public class CombinationSum2 {
    public static void main(String[] args) {
        System.out.println(combinationSum2(new int[]{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                8));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer,Integer> hm = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        combSum(target,res,0,new ArrayList<>(),candidates);
        return res;
    }
    private static void combSum(int target, List<List<Integer>> res,int start, List<Integer> temp , int [] nums){
        if (target<0){
            return;
        }
        if (start == nums.length){
            if (target==0){
                if (!res.contains(temp))
                    res.add(new ArrayList<>(temp));
            }
            return;
        }
        if (nums[start] <= target){
            temp.add(nums[start]);
            combSum(target - nums[start], res, start+1, temp, nums);
            temp.remove(temp.size()-1);
        }
        combSum(target,res,start+1,temp,nums);
    }
}
