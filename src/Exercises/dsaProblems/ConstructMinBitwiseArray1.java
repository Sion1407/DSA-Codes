package Exercises.dsaProblems;

import java.util.List;

public class ConstructMinBitwiseArray1 {
    public static void main(String[] args) {
        int[] res = minBitwiseArray(List.of(2,3,5,7));
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
    }
    public static int[] minBitwiseArray(List<Integer> nums) {
        int res[] = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            int num = nums.get(i);
            int k = -1;

            // Iterate over possible values of ans[i]
            for (int l = 0; l < num; l++) {
                // Check if the condition holds: l OR (l + 1) == num
                if ((l | (l + 1)) == num) {
                    k = l; // Store the valid value of ans[i]
                    break;
                }
            }

            // If no valid ans[i] was found, set to -1
            res[i] = (k == -1 ? -1 : k);
        }
        return res;
    }
}
