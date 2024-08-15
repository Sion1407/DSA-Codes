package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation2 {
    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1,1,2}));
    }
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(res, nums,new ArrayList<>(), new ArrayList<>());
        return res;
    }

    private static void helper(List<List<Integer>> res,  int[]nums,List<Integer> consumedIdx,List<Integer> temp){
        if (temp.size()==nums.length){
            res.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!consumedIdx.contains(i)){
                temp.add(nums[i]);
                consumedIdx.add(i);
                helper(res,nums,consumedIdx,temp);
                temp.remove(temp.size()-1);
                consumedIdx.remove(consumedIdx.size()-1);
                while (i<nums.length-1 && nums[i]==nums[i+1]){
                    i++;
                }
            }
        }
    }
}
