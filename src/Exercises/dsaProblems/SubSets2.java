package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSets2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(arr);
        backTrack(res,new ArrayList<>(),arr, 0);
        System.out.println(res);
    }

//    public static void printSubArrays(int[] nums, int start, int tail, ArrayList<ArrayList<Integer>> res) {
//        if (tail == nums.length) return;
//        else if (start > tail)
//            printSubArrays(nums,0,tail+1,res);
//
//        else {
//            ArrayList<Integer> temp = new ArrayList<>();
//            for (int i=start;i<=tail;i++){
//                temp.add(nums[i]);
//            }
//            res.add(temp);
//            printSubArrays(nums,start+1,tail,res);
//        }
//
//    }

    public static void backTrack(List<List<Integer>> res,List<Integer> tempSet,int[] nums, int start ){
//        if the subset is already present in the arraylist dont add it
        if (res.contains(tempSet))
            return;
        res.add(new ArrayList<>(tempSet));
        for (int i = start;i< nums.length;i++){
//            case of including the number
            tempSet.add(nums[i]);
//            backtrack to the new subset
            backTrack(res,tempSet,nums,i+1);
//            case of not including the subset
            tempSet.remove(tempSet.size()-1);

        }
    }

}