package Exercises.dsaProblems;

import java.util.ArrayList;
import java.util.List;
//3364
public class MinimumPositiveSumSubarray {
    public static void main(String[] args) {
//        in range of l and r which means eg l =1 and r =3 then subarrays can be of size 1,2 and 3
        System.out.println(minimumSumSubarray(List.of(5,8,-6),1,3));
    }
    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minSum = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            int currSum = 0;

            for (int j = 0; j < i; j++) {
                currSum += nums.get(j);
            }
            if (currSum > 0) {
                minSum = Math.min(minSum, currSum);
            }

            int low = 0, high = i;

            while (high < nums.size()) {
                currSum -= nums.get(low);
                currSum += nums.get(high);

                low++;
                high++;

                if (currSum > 0) {
                    minSum = Math.min(minSum, currSum);
                }
            }
        }
        if (minSum == Integer.MAX_VALUE) return -1;
        return minSum;
    }
}
