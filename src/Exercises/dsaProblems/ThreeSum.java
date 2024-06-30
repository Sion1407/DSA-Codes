package Exercises.dsaProblems;

import java.util.*;

//other approach
// i j and k
// k = nums.length
// loop through list via i
// j = i+1;
// if the sum is less that 0 incr j
//else decr k
// check for prev val if its dupl.

public class ThreeSum {
    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,0}));
    }
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int x=0,y=0;
        Arrays.sort(nums);
            for (int i = 0; i < nums.length-2; i++) {
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                x = i+1;
                y = nums.length-1;
                while (x<y) {
                    if (nums[x] + nums[y] + nums[i] == 0) {

                        List<Integer> temp = new ArrayList<>();
                        temp.add(nums[x]);
                        temp.add(nums[y]);
                        temp.add(nums[i]);
                        res.add(temp);
                        while (x < y && nums[x] == nums[x + 1]) {
                            x++;
                        }
                        while (x < y && nums[y] == nums[y - 1]) {
                            y--;
                        }
                        y--;
                        x++;
                    }
                    else if (nums[x] + nums[y] + nums[i] < 0) {
                        x++;
                    } else {
                        y--;
                    }
                }
            }
        return res;
    }
}
