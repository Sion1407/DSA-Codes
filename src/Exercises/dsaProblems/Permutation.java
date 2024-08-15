package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;
//47
public class Permutation {
    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,3}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, nums, new ArrayList<>());
        return res;
    }
    public static void helper(List<List<Integer>> res, int[] nums,  List<Integer> temp){
        if (temp.size()== nums.length) {
            res.add(new ArrayList<>(temp));
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            helper(res,nums,temp);
            temp.remove(temp.size()-1);
        }

    }
}
