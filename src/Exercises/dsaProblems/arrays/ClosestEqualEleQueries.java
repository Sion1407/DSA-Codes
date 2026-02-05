package Exercises.dsaProblems.arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 0  1  2  3  4  5  6  7  8  9  10 11 12 13
//[1, 3, 1, 4, 1, 3, 2, 1, 3, 1, 4, 1, 3, 2]
// j = 5 ,  k = 6, nums = 7
// j = 5 , k = 8,
// k- nums -1 == j
// 12 - 7 == 5
public class ClosestEqualEleQueries {
    public static void main(String[] args) {
        System.out.println(solveQueries(new int[]{2, 10, 20, 20, 20}, new int[]{1, 4, 2}));
    }

    public static List<Integer> solveQueries(int[] nums, int[] queries) {
        int sz = nums.length;
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < sz; i++) {
            indices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }
        for (List<Integer> arr : indices.values()) {
            int m = arr.size();
            if (m == 1) {
                nums[arr.get(0)] = -1;
                continue;
            }
            for (int i = 0; i < m; i++) {
                int j = arr.get(i);
                int f = arr.get((i + 1) % m), b = arr.get((i - 1 + m) % m);
                int forward = Math.min((sz - j - 1) + f + 1, Math.abs(j - f));
                int backward = Math.min(Math.abs(b - j), j + (sz - b));
                nums[j] = Math.min(backward, forward);
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int q : queries) {
            res.add(nums[q]);
        }
        return res;
    }

}
