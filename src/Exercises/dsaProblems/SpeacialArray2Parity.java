package Exercises.dsaProblems;

//You are given an array of integer nums and a 2D integer matrix queries, where for queries[i] = [fromi, toi] your task is to check that
//        subarray
//        nums[fromi..toi] is special or not.
//
//        Return an array of booleans answer such that answer[i] is true if nums[fromi..toi] is special.
//
//
//
//        Example 1:
//
//        Input: nums = [3,4,1,2,6], queries = [[0,4]]
//
//        Output: [false]
//
//        Explanation:
//
//        The subarray is [3,4,1,2,6]. 2 and 6 are both even.
//
//        Example 2:
//
//        Input: nums = [4,3,1,6], queries = [[0,2],[2,3]]
//
//        Output: [false,true]
//
//        Explanation:
//
//        The subarray is [4,3,1]. 3 and 1 are both odd. So the answer to this query is false.
//        The subarray is [1,6]. There is only one pair: (1,6) and it contains numbers with different parity. So the answer to this query is true.
//
//
//        Constraints:
//
//        1 <= nums.length <= 105
//        1 <= nums[i] <= 105
//        1 <= queries.length <= 105
//        queries[i].length == 2
//        0 <= queries[i][0] <= queries[i][1] <= nums.length - 1


import java.util.Arrays;

public class SpeacialArray2Parity {
    public static void main(String[] args) {
//        int[][] array = new int[][]{{0, 2}, {2, 3}};
//        System.out.println(isArraySpecial(new int[]{4, 3, 1, 6}, array)[0]);
        int[][] array = new int[][]{{1, 2}};
        System.out.println(isArraySpecial(new int[]{1,2,3}, array)[0]);
    }

    public static boolean[] isArraySpecial(int[] nums,int[][] query){
        int ps[] = new int[nums.length];
        boolean[] res = new boolean[query.length];
        for (int i = 1 ; i< nums.length;i++){
            ps[i] = ps[i-1];
            if (ps[i-1]%2==ps[i]%2 ){
                ps[i]++;
            }
        }
        for (int i = 0;i< query.length;i++){
            int from = query[i][0], to = query[i][1];
            int cnt = to-from;
            res[i] = cnt > 0 ? false : true;
        }
        return res;
    }


}
