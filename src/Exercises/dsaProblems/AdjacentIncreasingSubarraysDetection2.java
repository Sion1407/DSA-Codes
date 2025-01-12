package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AdjacentIncreasingSubarraysDetection2 {
    public static void main(String[] args) {
        List<Integer> lst = new ArrayList<>(Arrays.asList(4,13,2,3));
        System.out.println(maxIncreasingSubarrays(lst));
    }
    public static int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size(), curr = 1, prev = 0,longSub=0;
        Collections.sort(nums);
        System.out.println(nums);
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i)>=nums.get(i-1)){
                curr+=1;
            }
            else{
                prev = curr;
                curr = 1;
            }
            longSub = Math.max(longSub,Math.max(curr/2,Math.min(curr,prev)));

        }
        return longSub;
    }
}
